package models.serviciosMeteorologicos;

import models.registroDeAlertas.AlertaMeteorologica;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

//por el momento para el req 5 uso la solución que dieron, falta implementar una propia

public interface ServicioMeteorologico {


    public Map<String, Object> obtenerCondicionesClimaticas(String direccion);

    public LocalDateTime proximaExpiracion();

    public Map<String, Object> consultarApi(String direccion);

    public List<AlertaMeteorologica> obtenerUltimasAlertasMetereologicas(String ciudad);

    public List<AlertaMeteorologica> adaptarListaDeAlertas(List<String> alertas);

    public AlertaMeteorologica adaptarAlerta(String alerta);


}