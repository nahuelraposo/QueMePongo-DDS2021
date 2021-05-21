package dominio.sugerencia;

import dominio.Atuendo;
import dominio.prenda.Prenda;

import java.util.List;

public interface GeneradorSugerencias {

    public List<Atuendo> generarSugerenciasDesde(List<Prenda> prendasAptas);
}
