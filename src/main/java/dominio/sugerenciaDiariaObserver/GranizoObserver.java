package dominio.sugerenciaDiariaObserver;

import dominio.RepositorioUsuarios;

public class GranizoObserver implements PronosticoObserver {

  public void notificarAlertaMetereologica() {
    RepositorioUsuarios.getInstance()
        .getUsuarios()
        .forEach(usuario -> usuario.notificarAlertaMetereologica("¡ALERTA DE GRANIZO! TE RECOMENDAMOS EVITAR SALIR CON EL AUTO"));
  }
}
