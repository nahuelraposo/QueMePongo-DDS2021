package dominio.proveedorDeClima;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProveedorDeClima {
  private AccuWeatherAPI apiClima;
  private List<Alerta> alertasMetereologicasDiarias;

  public List<Alerta> obtenerUltimasAlertasMetereologicas(String ciudad){
      List<String> alertas =apiClima
        .getAlerts(ciudad)
        .get("CurrentAlerts");
      List<Alerta> alertasAdaptadas = this.adaptarListaDeAlertas(alertas);
      return  alertasAdaptadas;
  }

  private List<Alerta> adaptarListaDeAlertas(List<String> alertas) {
    List<Alerta> alertasAdaptadas = alertas.stream().map(alerta -> this.adaptarAlerta(alerta)).collect(Collectors.toList());
    return alertasAdaptadas;
  }

  private Alerta adaptarAlerta(String alerta) {
    if (alerta.equals("TORMENTA")) {
      return Alerta.TORMENTA;
    }
    else if(alerta.equals("GRANIZO")){
      return  Alerta.GRANIZO;
    }
    return null;
  }

  public Object obtenerCondicionClimatica(String ciudad, BigDecimal hora){
    return apiClima
        .getWeather(ciudad)
        .get(hora.intValue())
        .get("Temperature");
  }

  public void consultarYActualizarAlertasMetereologicasDiarias(String ciudad){
    List<Alerta> alertas = this.obtenerUltimasAlertasMetereologicas(ciudad);
    this.alertasMetereologicasDiarias = alertas;
  }

}
