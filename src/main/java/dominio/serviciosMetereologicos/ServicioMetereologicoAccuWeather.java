package dominio.serviciosMetereologicos;

import dominio.AccuWeatherAPI;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioMetereologicoAccuWeather implements  ServicioMetereologico{
    private AccuWeatherAPI api;
    private Duration periodoDeValidez;
    private Map<String, RespuestaAccuWeather> ultimasRespuestas;

    public ServicioMetereologicoAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
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

    public LocalDateTime proximaExpiracion() {
        return LocalDateTime.now().plus(this.periodoDeValidez);
    }

    public Map<String, Object> consultarApi(String direccion) {
        return this.api.getWeather(direccion).get(LocalDateTime.now().getHour());
    }
}
