package dominio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//por el momento para el req 5 uso la solución que dieron, falta implementar una propia

public class ServicioMetereologico {
    private AccuWeatherAPI api;
    private Duration periodoDeValidez;
    private Map<String, RespuestaAccuWeather> ultimasRespuestas;

    public ServicioMetereologico(AccuWeatherAPI api, Duration periodoDeValidez) {
        this.api = api;
        this.periodoDeValidez = periodoDeValidez;
        this.ultimasRespuestas = new HashMap<>();
    }

    public Map<String, Object> obtenerCondicionesClimaticas(String direccion) {
        if (!this.ultimasRespuestas.containsKey(direccion) || this.ultimasRespuestas.get(direccion).expiro()) {
            ultimasRespuestas.put(direccion.toString(),(new RespuestaAccuWeather(this.consultarApi(direccion), this.proximaExpiracion())));
        }
        return this.ultimasRespuestas.get(direccion).getEstadoDelTiempo();
    }

    private LocalDateTime proximaExpiracion() {
        return LocalDateTime.now().plus(this.periodoDeValidez);
    }

    private Map<String, Object> consultarApi(String direccion) {
        return this.api.getWeather(direccion).get(LocalDateTime.now().getHour());
    }


}