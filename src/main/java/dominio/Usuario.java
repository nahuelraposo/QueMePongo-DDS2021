package dominio;

import dominio.excepciones.AtuendoNoAptoParaTemperaturaException;
import dominio.excepciones.SugerenciaIncompletaException;
import dominio.guardarropa.Guardarropa;
import dominio.guardarropa.Recomendacion;
import dominio.prenda.Prenda;
import dominio.serviciosMetereologicos.ServicioMetereologico;
import dominio.generadorSugerencia.GeneradorSugerencias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usuario {
    private List<Guardarropa> guardarropas;
    private ServicioMetereologico servicioMetereologico;
    private GeneradorSugerencias generadorSugerencias;
    private List<Recomendacion> recomendaciones = new ArrayList<>();
    private String ciudad;
    private List<Atuendo> atuendosDiariosSugeridos;

    public Usuario(List<Guardarropa> guardarropas, ServicioMetereologico servicioMetereologico, GeneradorSugerencias generadorSugerencias){
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

    public List<String> obtenerUltimasAlertasMetereologicas(AccuWeatherAPI apiClima){
        return apiClima
                .getAlerts(ciudad)
                .get("CurrentAlerts");
    }

    public List<Atuendo> atuendosSugeridos(){
        Map<String, Object> estadoDelTiempo = servicioMetereologico.obtenerCondicionesClimaticas(ciudad);
        List<Atuendo> atuendosSugeridos = generadorSugerencias.generarSugerenciasDesde(this.prendasEnTotal());
        validarAtuendos(atuendosSugeridos);
        validarAtuendosAptosParaTemperatura(atuendosSugeridos,estadoDelTiempo);

        return atuendosSugeridos;
    }

    public void actualizarAtuendosDiariosSugeridos(){
        List<Atuendo> sugerencias = this.atuendosSugeridos();
        this.atuendosDiariosSugeridos = sugerencias;
    }

    public void agregarRecomendacion(Recomendacion recomendacion) {
        this.getRecomendaciones().add(recomendacion);
    }

    public void aceptarRecomendacion(Recomendacion recomendacion){
        recomendacion.ejecutar(this);
    }

    public void rechazarRecomendacion(Recomendacion recomendacion){
        recomendaciones.remove(recomendacion);
    }

    public void deshacerRecomendacion(Recomendacion recomendacion){
        recomendacion.deshacer(this);
        recomendaciones.remove(recomendacion);
    }

    public List<Prenda> prendasEnTotal(){
        List<Prenda> prendasTotales = new ArrayList<>();
        this.getGuardarropas().stream().map(guardarropa -> guardarropa.getPrendas()).forEach(guardarropa -> guardarropa.addAll(prendasTotales));
        return  prendasTotales;
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

    public void agregarGuardarropa(Guardarropa guardarropa){
        guardarropas.add(guardarropa);
    }

    public List<Guardarropa> getGuardarropas(){
        return guardarropas;
    }

    public List<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

}
