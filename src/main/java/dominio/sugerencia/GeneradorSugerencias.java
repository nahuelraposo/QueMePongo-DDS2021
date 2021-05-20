package dominio.sugerencia;

import dominio.prenda.Prenda;

import java.util.List;

public interface GeneradorSugerencias {

    public List<Sugerencia> generarSugerenciasDesde(List<Prenda> prendasAptas);
}
