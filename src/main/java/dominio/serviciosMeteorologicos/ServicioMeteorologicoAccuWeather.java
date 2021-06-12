package dominio.serviciosMeteorologicos;

import dominio.proveedorDeClima.AccuWeatherAPI;
import dominio.proveedorDeClima.AlertaMeteorologica;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {
    private AccuWeatherAPI api;
    private Duration periodoDeValidez;
    private Map<String, RespuestaAccuWeather> ultimasRespuestas;

    public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
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

    public List<AlertaMeteorologica> obtenerUltimasAlertasMetereologicas(String ciudad){
        List<String> alertas = api.getAlerts(ciudad).get("CurrentAlerts");
        List<AlertaMeteorologica> alertasAdaptadas = this.adaptarListaDeAlertas(alertas);
        return alertasAdaptadas;
    }

    public List<AlertaMeteorologica> adaptarListaDeAlertas(List<String> alertas) {
        List<AlertaMeteorologica> alertasAdaptadas = alertas.stream().map(alerta -> this.adaptarAlerta(alerta)).collect(Collectors.toList());
        return alertasAdaptadas;
    }

    public AlertaMeteorologica adaptarAlerta(String alerta) {
        if (alerta.equals("TORMENTA")) {
            return AlertaMeteorologica.TORMENTA;
        }
        else if(alerta.equals("GRANIZO")){
            return  AlertaMeteorologica.GRANIZO;
        }
        return null;
    }

    public LocalDateTime proximaExpiracion() {
        return LocalDateTime.now().plus(this.periodoDeValidez);
    }

    public Map<String, Object> consultarApi(String direccion) {
        return this.api.getWeather(direccion).get(LocalDateTime.now().getHour());
    }
}
