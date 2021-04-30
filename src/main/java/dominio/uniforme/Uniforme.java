package dominio.uniforme;

import dominio.prenda.Prenda;

public class Uniforme {
    Prenda prendaSuperior;
    Prenda prendaInferior;
    Prenda calzado;

    public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
    }
}
