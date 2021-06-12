package dominio.accionesConfigurables;

import dominio.Usuario;
import dominio.proveedorDeClima.AlertaMeteorologica;

import java.util.List;

public class TormentaObserver {

  public void nuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertasMeteorologicas) {
    if(alertasMeteorologicas.contains(AlertaMeteorologica.TORMENTA))
      usuario.notificar("¡ALERTA DE TORMENTA! TE RECOMENDAMOS SALIR CON PARAGUAS!");
  }

}
