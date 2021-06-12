package dominio.accionesConfigurables;

import dominio.Usuario;
import dominio.registroDeAlertas.AlertaMeteorologica;

import java.util.List;

public interface AccionConfigurable {

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas);

}
