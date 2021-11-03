package models.accionesConfigurables;

import models.Usuario;
import models.registroDeAlertas.AlertaMeteorologica;

import java.util.List;

public class GranizoObserver implements AccionConfigurable{

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertasMeteorologicas) {
    if(alertasMeteorologicas.contains(AlertaMeteorologica.GRANIZO))
      usuario.notificar("¡ALERTA DE GRANIZO! TE RECOMENDAMOS NO USAR EL AUTO!");
  }
}
