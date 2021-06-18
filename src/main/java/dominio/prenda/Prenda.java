package dominio.prenda;

import java.awt.*;

public class Prenda {
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;
    Trama trama;
    Object temperaturaApta;

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

    //esto hay que reveerlo, tengo que encontrar una forma mejor de
    //implementar la temperatura de la prenda
    public boolean aptaParaTemperatura(Object temperatura) {
       // return temperatura.equals(temperaturaApta);
        return true;
    }

    public void setTemperaturaApta(Object temperaturaApta) {
        this.temperaturaApta = temperaturaApta;
    }
}
