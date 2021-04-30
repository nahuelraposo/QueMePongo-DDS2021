package dominio.uniforme;

import dominio.prenda.Prenda;

public abstract class Diseñador {


    public Uniforme fabricarUniforme() {
        return new Uniforme(this.fabricarPrendaSuperior(), this.fabricarPrendaInferior(),
                this.fabricarCalzado());
    }

    public Prenda fabricarPrendaInferior() {
        return null;
    }

    public Prenda fabricarCalzado() {
        return null;
    }

    public Prenda fabricarPrendaSuperior() {
        return null;
    }
}
