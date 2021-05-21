package dominio;

import dominio.prenda.Prenda;

import java.math.BigDecimal;
import java.util.List;

public class Usuario {
    List<Prenda> guardarropas;

    public Object condicionClimatica(String ciudad, BigDecimal hora, AccuWeatherAPI apiClima){
        return apiClima
                .getWeather(ciudad)
                .get(hora.intValue())
                .get("Temperature");
    }

    public List<Prenda> getGuardarropas(){
        return guardarropas;
    }
}
