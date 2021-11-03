package models.accionesConfigurables;

import models.Usuario;
import models.registroDeAlertas.AlertaMeteorologica;

import java.util.List;

public class RecalculadorDeSugerencias implements AccionConfigurable{

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertasMeteorologicas) {
    usuario.actualizarAtuendosDiariosSugeridos();
  }
}
