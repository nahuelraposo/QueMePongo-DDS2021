package models.accionesConfigurables;

import models.Usuario;
import models.registroDeAlertas.AlertaMeteorologica;

import java.util.List;

public class TormentaObserver implements AccionConfigurable{

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertasMeteorologicas) {
    if(alertasMeteorologicas.contains(AlertaMeteorologica.TORMENTA))
      usuario.notificar("¡ALERTA DE TORMENTA! TE RECOMENDAMOS SALIR CON PARAGUAS!");
  }

}
