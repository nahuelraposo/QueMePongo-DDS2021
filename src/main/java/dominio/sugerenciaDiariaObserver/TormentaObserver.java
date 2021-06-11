package dominio.sugerenciaDiariaObserver;

import dominio.RepositorioUsuarios;

public class TormentaObserver implements PronosticoObserver {

  public void notificarAlertaMetereologica() {
    RepositorioUsuarios.getInstance()
        .getUsuarios()
        .forEach(usuario -> usuario.notificarAlertaMetereologica("¡ALERTA DE TORMENTA! TE RECOMENDAMOS USAR PARAGUAS"));
  }
}
