import dominio.MainPrueba;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class MainAutomaticoQuartz {
  public static void main(String[] args) {
    String[] argumentos;

    try {
// Creacion de una instacia de Scheduler
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      System.out.println("Iniciando Scheduler...");
      scheduler.start();
// Creacion una instacia de JobDetail
      JobDetail jobDetail = new JobDetailImpl(
          "HolaMundoJob",
          Scheduler.DEFAULT_GROUP,
          MainPrueba.class);

// Creacion de un Trigger donde indicamos
//que el Job se
// ejecutara de inmediato y a partir de ahi en lapsos
// de 5 segundos por 10 veces mas.
      Trigger trigger = new SimpleTriggerImpl(
          "HolaMundoTrigger",
          Scheduler.DEFAULT_GROUP,
          10, 5000);

// Registro dentro del Scheduler
      scheduler.scheduleJob(jobDetail, trigger);

// Damos tiempo a que el Trigger registrado
//termine su periodo
// de vida dentro del scheduler
      Thread.sleep(60000);

// Detenemos la ejecución de la
// instancia de Scheduler
      scheduler.shutdown();

    } catch (Exception e) {
      System.out.println("Ocurrió una excepción");
    }
  }
}

