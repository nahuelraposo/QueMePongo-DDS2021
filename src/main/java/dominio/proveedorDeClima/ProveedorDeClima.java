package dominio.proveedorDeClima;

import dominio.proveedorDeClima.AccuWeatherAPI;

import java.math.BigDecimal;
import java.util.List;

public class ProveedorDeClima {
  private AccuWeatherAPI apiClima;
  private List<String> alertasMetereologicasDiarias;

  public List<String> obtenerUltimasAlertasMetereologicas(String ciudad){
    return apiClima
        .getAlerts(ciudad)
        .get("CurrentAlerts");
  }

  public Object obtenerCondicionClimatica(String ciudad, BigDecimal hora){
    return apiClima
        .getWeather(ciudad)
        .get(hora.intValue())
        .get("Temperature");
  }

  public void consultarYActualizarAlertasMetereologicasDiarias(String ciudad){
    List<String> alertas = this.obtenerUltimasAlertasMetereologicas(ciudad);
    this.alertasMetereologicasDiarias = alertas;
  }

}
