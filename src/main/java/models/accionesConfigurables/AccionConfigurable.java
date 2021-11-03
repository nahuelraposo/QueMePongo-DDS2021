package models.accionesConfigurables;

import models.Usuario;
import models.registroDeAlertas.AlertaMeteorologica;

import java.util.List;

public interface AccionConfigurable {

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas);

}
