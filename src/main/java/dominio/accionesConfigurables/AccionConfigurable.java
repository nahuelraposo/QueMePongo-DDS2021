package dominio.accionesConfigurables;

import dominio.Usuario;
import dominio.proveedorDeClima.AlertaMeteorologica;

import java.util.List;

public interface AccionConfigurable {

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas);

}
