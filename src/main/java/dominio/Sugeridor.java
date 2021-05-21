package dominio;

import dominio.excepciones.SugerenciaIncompletaException;
import dominio.sugerencia.GeneradorSugerencias;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sugeridor {
    private ServicioMetereologico servicioMetereologico;
    private GeneradorSugerencias generadorSugerencias;

    // en esta parte voy a sugerir atuendos y verificar que cada uno
    //tenga al menos una prenda para cada categoria
    public List<Atuendo> sugerirAtuendos(String direccion, Usuario usuario){
        Map<String, Object> estadoDelTiempo = servicioMetereologico.obtenerCondicionesClimaticas(direccion);
        List<Atuendo> atuendosSugeridos = generadorSugerencias.generarSugerenciasDesde(usuario.getGuardarropas());

        List<Atuendo> atuendosFiltrados = this.filtrarAtuendos(atuendosSugeridos,estadoDelTiempo);
        validarAtuendos(atuendosFiltrados);

        return atuendosFiltrados;
    }

    private List<Atuendo> filtrarAtuendos(List<Atuendo> atuendosSugeridos, Map<String, Object> estadoDelTiempo) {
        return atuendosSugeridos.stream()
                .filter(atuendo -> atuendo.aptoParaTemperatura(estadoDelTiempo))
                .collect(Collectors.toList());
    }


    private void validarAtuendos(List<Atuendo> atuendos) {
        if(!atuendos.stream().allMatch(atuendo -> atuendo.cumpleCondicion())){
            throw new SugerenciaIncompletaException();
        }

    }

}
