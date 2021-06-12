package dominio.sugerenciaDiariaObserver;

public interface PronosticoObserver {

  public void notificarAlertaMetereologica();

  public void setMensaje(String mensaje);
}
