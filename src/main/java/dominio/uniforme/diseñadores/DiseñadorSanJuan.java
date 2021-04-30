package dominio.uniforme.diseñadores;

import dominio.Borrador;
import dominio.prenda.Material;
import dominio.prenda.Prenda;
import dominio.prenda.TipoPrenda;
import dominio.uniforme.Diseñador;

import java.awt.*;

public class DiseñadorSanJuan extends Diseñador {

    @Override
    public Prenda fabricarPrendaInferior() {
       Borrador borrador = new Borrador();
       borrador.establecerTipoPrenda(TipoPrenda.PANTALON);
       borrador.establecerMaterial(Material.ACETATO);
       borrador.establecerColorPrincipal(Color.GRAY);
       return borrador.crearPrenda();
    }

    @Override
    public Prenda fabricarCalzado() {
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(TipoPrenda.ZAPATILLAS);
        borrador.establecerMaterial(Material.CUERO);
        borrador.establecerColorPrincipal(Color.white);
        return borrador.crearPrenda();
    }

    @Override
    public Prenda fabricarPrendaSuperior() {
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(TipoPrenda.CHOMBA);
        borrador.establecerMaterial(Material.PIQUE);
        borrador.establecerColorPrincipal(Color.GREEN);
        return borrador.crearPrenda();
    }
}
