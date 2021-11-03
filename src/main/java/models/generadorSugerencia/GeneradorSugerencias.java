package models.generadorSugerencia;

import models.Atuendo;
import models.prenda.Prenda;

import java.util.List;

public interface GeneradorSugerencias {

    public List<Atuendo> generarSugerenciasDesde(List<Prenda> prendasAptas);
}
