package dominio;

import dominio.accionesConfigurables.RecalculadorDeSugerencias;
import dominio.generadorSugerencia.GeneradorSugerenciaPrueba;
import dominio.guardarropa.Guardarropa;
import dominio.notificador.MailSender;
import dominio.prenda.Borrador;
import dominio.prenda.Material;
import dominio.prenda.Prenda;
import dominio.registroDeAlertas.AlertaMeteorologica;
import dominio.registroDeAlertas.RegistroAlertas;
import dominio.repositorios.RepositorioUsuarios;
import dominio.serviciosMeteorologicos.AccuWeatherAPI;
import dominio.serviciosMeteorologicos.ServicioMeteorologico;
import org.quartz.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static dominio.prenda.TipoPrenda.*;

public class MainPrueba implements Job{

  public void execute(JobExecutionContext jobExecutionContext)
        throws  JobExecutionException{
    RepositorioUsuarios repoUsuarios = RepositorioUsuarios.getInstance();
    AccuWeatherAPI api = new AccuWeatherAPI();
    ServicioMeteorologico servicioMeteorologico = this.servicioMeteorologicoOverraideado();

    List<AlertaMeteorologica> alertasMeteorologicas = new ArrayList<>();
    alertasMeteorologicas.add(AlertaMeteorologica.TORMENTA);
    RegistroAlertas registroAlertas = new RegistroAlertas(servicioMeteorologico,alertasMeteorologicas);

    //Genero prendas
    Borrador borrador1 = new Borrador();
    borrador1.establecerTipoPrenda(ANTEOJOS);
    borrador1.establecerMaterial(Material.PLASTICO);
    borrador1.establecerColorPrincipal(Color.YELLOW);
    Prenda anteojosDeSol = borrador1.crearPrenda();

    Borrador borrador2 = new Borrador();
    borrador2.establecerTipoPrenda(REMERA_MANGA_CORTA);
    borrador2.establecerMaterial(Material.ALGODON);
    borrador2.establecerColorPrincipal(Color.BLUE);
    Prenda remeraMangasCortasAzul = borrador1.crearPrenda();

    List<Prenda> prendas = new ArrayList<>();
    prendas.add(anteojosDeSol);
    prendas.add(remeraMangasCortasAzul);

    //Genero guardarropas
    Guardarropa guardarropa1 = new Guardarropa(prendas);
    List<Guardarropa> guardarropas1 = new ArrayList<>();
    guardarropas1.add(guardarropa1);
    Guardarropa guardarropa2 = new Guardarropa(prendas);
    List<Guardarropa> guardarropas2 = new ArrayList<>();
    guardarropas1.add(guardarropa2);
    //Genero usuarios
    Usuario usuario1 = new Usuario(guardarropas1,servicioMeteorologico,new GeneradorSugerenciaPrueba(),
                                  new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"Buenos Aires","elpepe",new MailSender(null));
    Usuario usuario2 = new Usuario(guardarropas2,servicioMeteorologico,new GeneradorSugerenciaPrueba(),
        new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"Buenos Aires","elpepe",new MailSender(null));

    repoUsuarios.agregarUsuario(usuario1);
    repoUsuarios.agregarUsuario(usuario2);

    //Agrego acciones
    RecalculadorDeSugerencias recalculadorDeSugerencias = new RecalculadorDeSugerencias();
    usuario1.agregarAccion(recalculadorDeSugerencias);
    usuario2.agregarAccion(recalculadorDeSugerencias);


    registroAlertas.actualizarAlertas("Buenos Aires");
    repoUsuarios.actualizarSugerenciasDiariasDeUsuarios();


    System.out.println(registroAlertas.getAlertas());
    System.out.println(usuario1.getAtuendosDiariosSugeridos());
    System.out.println(usuario2.getAtuendosDiariosSugeridos());
    System.out.println(repoUsuarios.getUsuarios());

    repoUsuarios.quitarUsuario(usuario1);
    repoUsuarios.quitarUsuario(usuario2);
  }


  public ServicioMeteorologico servicioMeteorologicoOverraideado(){
    AccuWeatherAPI api = new AccuWeatherAPI();
    return new ServicioMeteorologico() {
      @Override
      public Map<String, Object> obtenerCondicionesClimaticas(String direccion) {
        return api.getWeather("Buenos Aires").get(0);
      }

      @Override
      public LocalDateTime proximaExpiracion() {
        return null;
      }

      @Override
      public Map<String, Object> consultarApi(String direccion) {
        return null;
      }

      @Override
      public List<AlertaMeteorologica> obtenerUltimasAlertasMetereologicas(String ciudad) {
        List<AlertaMeteorologica> alertasMeteorologicas = new ArrayList<>();
        alertasMeteorologicas.add(AlertaMeteorologica.TORMENTA);
        alertasMeteorologicas.add(AlertaMeteorologica.GRANIZO);
        return alertasMeteorologicas;
      }

      @Override
      public List<AlertaMeteorologica> adaptarListaDeAlertas(List<String> alertas) {
        return null;
      }

      @Override
      public AlertaMeteorologica adaptarAlerta(String alerta) {
        return null;
      }
    };
  }
}
