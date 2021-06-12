package dominio.sugerenciaDiariaObserver;

import dominio.RepositorioUsuarios;

public class GranizoObserver implements PronosticoObserver {
  String mensaje = "¡ALERTA DE GRANIZO! TE RECOMENDAMOS EVITAR SALIR CON EL AUTO";

  public void notificarAlertaMetereologica() {
    RepositorioUsuarios.getInstance()
        .getUsuarios()
        .forEach(usuario -> usuario.notificarAlertaMetereologica(mensaje));
  }

  public void setMensaje(String mensaje){
    this.mensaje = mensaje;
  }
}
