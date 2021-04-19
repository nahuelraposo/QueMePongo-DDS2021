package dominio.prenda;

import dominio.excepciones.PrendaIncompletaException;

public class Prenda {
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;

    public Prenda(TipoPrenda tipo, Material materialPrenda,
                  Color colorPrimario) {
        validarAtributos(tipo, materialPrenda, colorPrimario);
        this.tipoPrenda = tipo;
        this.material = materialPrenda;
        this.colorPrincipal = colorPrimario;
    }

    //la prenda puede tener O NO, color secundario, por eso creo otro constructor//
    public Prenda(TipoPrenda tipo, Material materialPrenda,
                  Color colorPrimario, Color colorSecundario) {
        validarAtributos(tipo, materialPrenda, colorPrimario);
        this.tipoPrenda = tipo;
        this.material = materialPrenda;
        this.colorPrincipal = colorPrimario;
        this.colorSecundario = colorSecundario;
    }

    private void validarAtributos(TipoPrenda tipo, Material materialPrenda, Color colorPrimario) {
        if (tipo == null || materialPrenda == null || colorPrimario == null)
            throw new PrendaIncompletaException();
    }

}
