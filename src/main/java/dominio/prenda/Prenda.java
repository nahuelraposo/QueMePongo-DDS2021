package dominio.prenda;

import dominio.excepciones.PrendaIncompletaException;

import java.awt.*;
import java.awt.color.*;
public class Prenda {
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;
    Trama trama;

    public Prenda(TipoPrenda tipo, Material materialPrenda,
                  Color colorPrimario, Color colorSecundario, Trama trama) {
        validarAtributos(tipo, materialPrenda, colorPrimario);
        this.tipoPrenda = tipo;
        this.material = materialPrenda;
        this.colorPrincipal = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
    }

    private void validarAtributos(TipoPrenda tipo, Material materialPrenda, Color colorPrimario) {
        if (tipo == null || materialPrenda == null || colorPrimario == null)
            throw new PrendaIncompletaException();
    }

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public Trama getTrama(){
        return trama;
    }
}
