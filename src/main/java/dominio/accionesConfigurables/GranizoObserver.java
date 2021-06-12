package dominio.accionesConfigurables;

import dominio.Usuario;
import dominio.registroDeAlertas.AlertaMeteorologica;

import java.util.List;

public class GranizoObserver {

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertasMeteorologicas) {
    if(alertasMeteorologicas.contains(AlertaMeteorologica.GRANIZO))
      usuario.notificar("¡ALERTA DE GRANIZO! TE RECOMENDAMOS NO USAR EL AUTO!");
  }
}
