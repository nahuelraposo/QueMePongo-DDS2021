package dominio;

import dominio.accionesConfigurables.AccionConfigurable;
import dominio.excepciones.AtuendoNoAptoParaTemperaturaException;
import dominio.excepciones.SugerenciaIncompletaException;
import dominio.guardarropa.Guardarropa;
import dominio.guardarropa.Recomendacion;
import dominio.notificador.Notificador;
import dominio.prenda.Prenda;
import dominio.registroDeAlertas.AlertaMeteorologica;
import dominio.serviciosMeteorologicos.ServicioMeteorologico;
import dominio.generadorSugerencia.GeneradorSugerencias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usuario {
    private List<Guardarropa> guardarropas;
    private ServicioMeteorologico servicioMeteorologico;
    private GeneradorSugerencias generadorSugerencias;
    private List<Recomendacion> recomendaciones;
    private List<Atuendo> atuendosDiariosSugeridos;
    private List<AccionConfigurable> accionesConfigurables;
    private String ciudad;
    private String email;
    private Notificador notificador;

    public Usuario(List<Guardarropa> guardarropas, ServicioMeteorologico servicioMeteorologico, GeneradorSugerencias generadorSugerencias,
                   List<Recomendacion> recomendaciones, List<Atuendo> atuendosDiariosSugeridos,
                   List<AccionConfigurable> accionesConfigurables,
                   String ciudad, String email, Notificador notificador){
        this.guardarropas = guardarropas;
        this.servicioMeteorologico = servicioMeteorologico;
        this.generadorSugerencias = generadorSugerencias;
        this.recomendaciones = recomendaciones;
        this. atuendosDiariosSugeridos = atuendosDiariosSugeridos;
        this.accionesConfigurables = accionesConfigurables;
        this.ciudad = ciudad;
        this.email = email;
        this.notificador = notificador;
    }

    public void notificar(String mensaje){
        notificador.notificar(email,mensaje);
    }

    public void realizarAccionesSobreAlertas(List<AlertaMeteorologica> alertasMetereologicasDiarias) {
        this.getAccionesConfigurables()
            .forEach(accionConfigurable -> accionConfigurable.nuevasAlertasMeteorologicas(this,alertasMetereologicasDiarias));
    }

    public List<Atuendo> atuendosSugeridos(){
        Map<String, Object> estadoDelTiempo = servicioMeteorologico.obtenerCondicionesClimaticas(ciudad);
        List<Atuendo> atuendosSugeridos = generadorSugerencias.generarSugerenciasDesde(this.prendasEnTotal());
        validarAtuendos(atuendosSugeridos);
        validarAtuendosAptosParaTemperatura(atuendosSugeridos,estadoDelTiempo);

        return atuendosSugeridos;
    }

    public void actualizarAtuendosDiariosSugeridos(){
        List<Atuendo> sugerencias = this.atuendosSugeridos();
        this.atuendosDiariosSugeridos = sugerencias;
    }

    public void aceptarRecomendacion(Recomendacion recomendacion){
        recomendacion.ejecutar(this);
    }

    public void rechazarRecomendacion(Recomendacion recomendacion){
        recomendaciones.remove(recomendacion);
    }

    public void deshacerRecomendacion(Recomendacion recomendacion){
        recomendacion.deshacer(this);
        recomendaciones.remove(recomendacion);
    }

    public Object condicionClimatica(String ciudad){
        return servicioMeteorologico.obtenerCondicionesClimaticas(ciudad);
    }

    public List<Prenda> prendasEnTotal(){
        List<Prenda> prendasTotales = new ArrayList<>();
        this.getGuardarropas().stream().map(guardarropa -> guardarropa.getPrendas()).forEach(guardarropa -> guardarropa.addAll(prendasTotales));
        return  prendasTotales;
    }

    public void agregarGuardarropa(Guardarropa guardarropa){
        guardarropas.add(guardarropa);
    }

    public void agregarAccion(AccionConfigurable accion){
        this.getAccionesConfigurables().add(accion);
    }

    public void quitarAccion(AccionConfigurable accion){
        this.getAccionesConfigurables().remove(accion);
    }

    private void validarAtuendosAptosParaTemperatura(List<Atuendo> atuendosSugeridos, Map<String, Object> estadoDelTiempo) {
        if(!losAtuendosSonAptosParaLaTemperatura(atuendosSugeridos, estadoDelTiempo)){
            throw new AtuendoNoAptoParaTemperaturaException();
        }
    }

    // en esta parte voy a verificar que cada uno
    //tenga al menos una prenda para cada categoria
    private void validarAtuendos(List<Atuendo> atuendos) {
       /* if(!atuendos.stream().allMatch(atuendo -> atuendo.cumpleCondicion())){
            throw new SugerenciaIncompletaException();
        }*/
    }

    private boolean losAtuendosSonAptosParaLaTemperatura(List<Atuendo> atuendosSugeridos, Map<String, Object> estadoDelTiempo) {
        return atuendosSugeridos.stream()
            .allMatch(atuendo -> atuendo.aptoParaTemperatura(estadoDelTiempo));
    }
    public void agregarRecomendacion(Recomendacion recomendacion) {
        this.getRecomendaciones().add(recomendacion);
    }

    public List<Guardarropa> getGuardarropas(){
        return guardarropas;
    }

    public List<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public List<AccionConfigurable> getAccionesConfigurables() {
        return accionesConfigurables;
    }

    public List<Atuendo> getAtuendosDiariosSugeridos() {
        return atuendosDiariosSugeridos;
    }
}
