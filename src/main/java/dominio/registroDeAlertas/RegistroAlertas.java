package dominio.registroDeAlertas;

import dominio.repositorios.RepositorioUsuarios;
import dominio.serviciosMeteorologicos.ServicioMeteorologico;

import java.util.List;

public class RegistroAlertas {
  private ServicioMeteorologico servicioMeteorologico;
  private List<AlertaMeteorologica> alertasMetereologicasDiarias;
  private RepositorioUsuarios repoUsuarios = RepositorioUsuarios.getInstance();

  public void actualizarAlertas(String ciudad){
    this.alertasMetereologicasDiarias = servicioMeteorologico.obtenerUltimasAlertasMetereologicas(ciudad);
    this.realizarAccionesSobreAlertas();
  }

  public void realizarAccionesSobreAlertas(){
    repoUsuarios
        .getUsuarios()
        .forEach(usuario -> usuario.realizarAccionesSobreAlertas(alertasMetereologicasDiarias));
  }

  public List<AlertaMeteorologica> getAlertas() {
    return alertasMetereologicasDiarias;
  }
}
