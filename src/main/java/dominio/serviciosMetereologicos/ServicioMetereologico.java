package dominio.serviciosMetereologicos;

import dominio.AccuWeatherAPI;
import dominio.RespuestaAccuWeather;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//por el momento para el req 5 uso la solución que dieron, falta implementar una propia

public interface ServicioMetereologico {


    public Map<String, Object> obtenerCondicionesClimaticas(String direccion);

    public LocalDateTime proximaExpiracion();

    public Map<String, Object> consultarApi(String direccion);


}