package dominio.generadorSugerencia;

import dominio.Atuendo;
import dominio.prenda.Borrador;
import dominio.prenda.Material;
import dominio.prenda.Prenda;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static dominio.prenda.TipoPrenda.*;
import static dominio.prenda.TipoPrenda.ZAPATILLAS;

public class GeneradorSugerenciaPrueba implements GeneradorSugerencias{

  public List<Atuendo> generarSugerenciasDesde(List<Prenda> prendasAptas){
    Borrador borrador1 = new Borrador();
    borrador1.establecerTipoPrenda(ANTEOJOS);
    borrador1.establecerMaterial(Material.PLASTICO);
    borrador1.establecerColorPrincipal(Color.YELLOW);
    Prenda anteojosDeSol = borrador1.crearPrenda();

    Borrador borrador2 = new Borrador();
    borrador2.establecerTipoPrenda(REMERA_MANGA_CORTA);
    borrador2.establecerMaterial(Material.ALGODON);
    borrador2.establecerColorPrincipal(Color.BLUE);
    Prenda remeraMangasCortasAzul = borrador1.crearPrenda();

    Borrador borrador3 = new Borrador();
    borrador3.establecerTipoPrenda(POLLERA);
    borrador3.establecerMaterial(Material.LYCRA);
    borrador3.establecerColorPrincipal(Color.YELLOW);
    Prenda polleraAmarilla = borrador3.crearPrenda();

    Borrador borrador4 = new Borrador();
    borrador4.establecerTipoPrenda(ZAPATILLAS);
    borrador4.establecerColorPrincipal(Color.white);
    borrador4.establecerMaterial(Material.CUERO);
    Prenda zapatillasConverse = borrador4.crearPrenda();

    List<Prenda> prendas = new ArrayList<>();
    prendas.add(anteojosDeSol);
    prendas.add(remeraMangasCortasAzul);
    prendas.add(polleraAmarilla);
    prendas.add(zapatillasConverse);

    List<Atuendo> atuendos = new ArrayList<>();
    atuendos.add(new Atuendo(prendas));

    return atuendos;
  }
}
