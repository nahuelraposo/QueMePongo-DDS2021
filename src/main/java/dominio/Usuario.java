package dominio;

import dominio.prenda.Prenda;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Usuario {
    List<Prenda> guardarropas;


    public Map<String, Object> condicionClimatica(String ciudad, BigDecimal hora, AccuWeatherAPI apiClima){
        return apiClima.getWeather(ciudad).get(hora.intValue());
    }
}
