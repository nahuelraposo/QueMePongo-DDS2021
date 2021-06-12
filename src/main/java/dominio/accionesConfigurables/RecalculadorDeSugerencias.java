package dominio.accionesConfigurables;

import dominio.Usuario;

public class RecalculadorDeSugerencias {

  public void nuevasAlertasMeteorologicas(Usuario usuario) {
    usuario.actualizarAtuendosDiariosSugeridos();
  }
}
