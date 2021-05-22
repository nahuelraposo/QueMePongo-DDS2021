package dominio;

import dominio.excepciones.AtuendoNoAptoParaTemperaturaException;
import dominio.excepciones.SugerenciaIncompletaException;
import dominio.prenda.Prenda;
import dominio.serviciosMetereologicos.ServicioMetereologico;
import dominio.sugerencia.GeneradorSugerencias;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Usuario {
    private List<Prenda> guardarropas;
    private ServicioMetereologico servicioMetereologico;
    private GeneradorSugerencias generadorSugerencias;

    public Usuario(List<Prenda> guardarropas, ServicioMetereologico servicioMetereologico, GeneradorSugerencias generadorSugerencias){
        this.guardarropas = guardarropas;
        this.servicioMetereologico = servicioMetereologico;
        this.generadorSugerencias = generadorSugerencias;
    }

    public Object condicionClimatica(String ciudad, BigDecimal hora, AccuWeatherAPI apiClima){
        return apiClima
                .getWeather(ciudad)
                .get(hora.intValue())
                .get("Temperature");
    }

    public List<Atuendo> atuendosSugeridos(String direccion){
        Map<String, Object> estadoDelTiempo = servicioMetereologico.obtenerCondicionesClimaticas(direccion);
        List<Atuendo> atuendosSugeridos = generadorSugerencias.generarSugerenciasDesde(this.getGuardarropas());
        validarAtuendos(atuendosSugeridos);
        validarAtuendosAptosParaTemperatura(atuendosSugeridos,estadoDelTiempo);

        return atuendosSugeridos;
    }

    private void validarAtuendosAptosParaTemperatura(List<Atuendo> atuendosSugeridos, Map<String, Object> estadoDelTiempo) {
            if(!losAtuendosSonAptosParaLaTemperatura(atuendosSugeridos, estadoDelTiempo)){
                throw new AtuendoNoAptoParaTemperaturaException();
            }
    }

    // en esta parte voy a verificar que cada uno
    //tenga al menos una prenda para cada categoria
    private void validarAtuendos(List<Atuendo> atuendos) {
        if(!atuendos.stream().allMatch(atuendo -> atuendo.cumpleCondicion())){
            throw new SugerenciaIncompletaException();
        }
    }

    private boolean losAtuendosSonAptosParaLaTemperatura(List<Atuendo> atuendosSugeridos, Map<String, Object> estadoDelTiempo) {
        return atuendosSugeridos.stream()
                .allMatch(atuendo -> atuendo.aptoParaTemperatura(estadoDelTiempo));
    }

    public List<Prenda> getGuardarropas(){
        return guardarropas;
    }
}
