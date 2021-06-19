package dominio.registroDeAlertas;

import dominio.repositorios.RepositorioUsuarios;
import dominio.serviciosMeteorologicos.ServicioMeteorologico;

import java.util.List;

public class RegistroAlertas {
  private ServicioMeteorologico servicioMeteorologico;
  private List<AlertaMeteorologica> alertasMetereologicasDiarias;
  private RepositorioUsuarios repoUsuarios;

  public RegistroAlertas(ServicioMeteorologico servicioMeteorologico,
                         List<AlertaMeteorologica> alertasMetereologicas,
                         RepositorioUsuarios repoUsuarios){
    this.servicioMeteorologico = servicioMeteorologico;
    this.alertasMetereologicasDiarias = alertasMetereologicas;
    this.repoUsuarios = repoUsuarios;
  }

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

  public RepositorioUsuarios getRepoUsuarios() {
    return repoUsuarios;
  }

  public ServicioMeteorologico getServicioMeteorologico() {
    return servicioMeteorologico;
  }
}
