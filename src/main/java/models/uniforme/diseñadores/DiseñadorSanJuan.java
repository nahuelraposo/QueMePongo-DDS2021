package models.uniforme.diseñadores;

import models.prenda.Borrador;
import models.prenda.Material;
import models.prenda.Prenda;
import models.prenda.TipoPrenda;
import models.uniforme.Diseñador;

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
