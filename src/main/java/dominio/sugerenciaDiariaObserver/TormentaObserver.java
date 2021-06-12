package dominio.sugerenciaDiariaObserver;

import dominio.RepositorioUsuarios;

public class TormentaObserver implements PronosticoObserver {
  String mensaje = "¡ALERTA DE TORMENTA! TE RECOMENDAMOS USAR PARAGUAS";

  public void notificarAlertaMetereologica() {
    RepositorioUsuarios.getInstance()
        .getUsuarios()
        .forEach(usuario -> usuario.notificarAlertaMetereologica(mensaje));
  }

  public void setMensaje(String mensaje){
    this.mensaje = mensaje;
  }
}
