package dominio.proveedorDeClima;

import dominio.RepositorioUsuarios;
import dominio.serviciosMeteorologicos.ServicioMeteorologico;

import java.util.List;

public class RegistroAlertas {
  private ServicioMeteorologico servicioMeteorologico;
  private List<AlertaMeteorologica> alertasMetereologicasDiarias;

  public void actualizarAlertas(String ciudad){
    this.alertasMetereologicasDiarias = servicioMeteorologico.obtenerUltimasAlertasMetereologicas(ciudad);
    this.realizarAccionesSobreAlertas();
  }

  public void realizarAccionesSobreAlertas(){
    RepositorioUsuarios.getInstance()
        .getUsuarios()
        .forEach(usuario -> usuario.realizarAccionesSobreAlertas(alertasMetereologicasDiarias));
  }

  public List<AlertaMeteorologica> getAlertas() {
    return alertasMetereologicasDiarias;
  }
}
