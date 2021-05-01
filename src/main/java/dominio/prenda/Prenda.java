package dominio.prenda;

import java.awt.*;

public class Prenda {
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;
    Trama trama;

    public Prenda(TipoPrenda tipo, Material materialPrenda,
                  Color colorPrimario, Color colorSecundario, Trama trama) {
        this.tipoPrenda = tipo;
        this.material = materialPrenda;
        this.colorPrincipal = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
    }

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public Trama getTrama(){
        return trama;
    }
}
