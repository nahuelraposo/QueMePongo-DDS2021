package dominio;

import dominio.excepciones.SugerenciaIncompletaException;
import dominio.prenda.Prenda;
import dominio.sugerencia.GeneradorSugerencias;
import dominio.sugerencia.Sugerencia;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Usuario {
    List<Prenda> guardarropas;


    public Map<String, Object> condicionClimatica(String ciudad, BigDecimal hora, AccuWeatherAPI apiClima){
        return apiClima.getWeather(ciudad).get(hora.intValue());
    }

    // en esta parte voy a recibir sugerencias de atuendos y verificar que cada una
    //tenga al menos una prenda para cada categoria
    public List<Sugerencia> recibirSugerencias(GeneradorSugerencias generadorSugerencias){
        List<Sugerencia> sugerencias = generadorSugerencias.generarSugerenciasDesde(guardarropas);
        validarSugerencias(sugerencias);
        return  sugerencias;
    }

    private void validarSugerencias(List<Sugerencia> sugerencias) {
        if(!sugerencias.stream().allMatch(sugerencia -> sugerencia.cumpleCondicion())){
            throw new SugerenciaIncompletaException();
        }

    }
}
