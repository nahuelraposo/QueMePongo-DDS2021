package dominio.uniforme.diseñadores;

import dominio.Borrador;
import dominio.prenda.Material;
import dominio.prenda.Prenda;
import dominio.prenda.TipoPrenda;
import dominio.uniforme.Diseñador;

import java.awt.*;

public class DiseñadorJohnson extends Diseñador {

    @Override
    public Prenda fabricarPrendaInferior() {
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(TipoPrenda.PANTALON_DE_VESTIR);
        borrador.establecerMaterial(Material.ALGODON);
        borrador.establecerColorPrincipal(Color.BLACK);
        return borrador.crearPrenda();
    }

    @Override
    public Prenda fabricarCalzado() {
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(TipoPrenda.ZAPATOS);
        borrador.establecerMaterial(Material.CUERO);
        borrador.establecerColorPrincipal(Color.BLACK);
        return borrador.crearPrenda();
    }

    @Override
    public Prenda fabricarPrendaSuperior() {
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(TipoPrenda.CAMISA);
        borrador.establecerMaterial(Material.ALGODON);
        borrador.establecerColorPrincipal(Color.white);
        return borrador.crearPrenda();
    }
}
