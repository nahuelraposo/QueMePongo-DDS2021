import dominio.Usuario;
import dominio.guardarropa.Guardarropa;
import dominio.guardarropa.Recomendacion;
import dominio.guardarropa.RecomendarAgregar;
import dominio.guardarropa.RecomendarQuitar;
import dominio.prenda.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static dominio.prenda.TipoPrenda.ANTEOJOS;
import static dominio.prenda.TipoPrenda.REMERA_MANGA_CORTA;

public class RecomendacionTest {
  List<Prenda> prendas = new ArrayList<>();
  Guardarropa guardarropa = new Guardarropa(prendas);
  List<Guardarropa> guardarropas = new ArrayList<>();
  Usuario usuario = new Usuario(guardarropas, null, null);
  Prenda anteojosDeSol = anteojosDeSol();
  Prenda remeraMangasCortasAzul = remeraMangasCortasAzul();

  Recomendacion recomendarAgregar = new RecomendarAgregar(anteojosDeSol);
  Recomendacion recomendarQuitar = new RecomendarQuitar(remeraMangasCortasAzul);

  @BeforeEach
  void setup() {
    guardarropas.add(guardarropa);
  }

  @Test
  public void unaRecomendacionAgregarSeAceptayLaPrendaIngresaAlGuardarropa() {
      usuario.agregarRecomendacion(recomendarAgregar);
      usuario.aceptarRecomendacion(recomendarAgregar,guardarropa);

    Assertions.assertTrue(guardarropa.getPrendas().contains(anteojosDeSol));
  }

  @Test
  public void unaRecomendacionAgregarSeRechazayLaPrendaNoIngresaAlGuardarropa() {
    usuario.agregarRecomendacion(recomendarAgregar);
    usuario.rechazarRecomendacion(recomendarAgregar);

    Assertions.assertFalse(guardarropa.getPrendas().contains(anteojosDeSol));
  }

  @Test
  public void unaRecomendacionAgregarSeDeshaceyLaPrendaQueIngresoSeQuita() {
    usuario.agregarRecomendacion(recomendarAgregar);
    usuario.aceptarRecomendacion(recomendarAgregar,guardarropa);
    usuario.deshacerRecomendacion(recomendarAgregar,guardarropa);

    Assertions.assertFalse(guardarropa.getPrendas().contains(anteojosDeSol));
  }

  @Test
  public void unaRecomendacionQuitarSeAceptayLaPrendaSaleDelGuardarropa() {
    guardarropa.agregarPrenda(remeraMangasCortasAzul);
    usuario.agregarRecomendacion(recomendarQuitar);
    usuario.aceptarRecomendacion(recomendarQuitar,guardarropa);

    Assertions.assertFalse(guardarropa.getPrendas().contains(remeraMangasCortasAzul));
  }


  //FIXTURE
  private Prenda anteojosDeSol(){
    Borrador borrador = new Borrador();
    borrador.establecerTipoPrenda(ANTEOJOS);
    borrador.establecerMaterial(Material.PLASTICO);
    borrador.establecerColorPrincipal(Color.YELLOW);
    return borrador.crearPrenda();
  }

  private Prenda remeraMangasCortasAzul(){
    Borrador borrador = new Borrador();
    borrador.establecerTipoPrenda(REMERA_MANGA_CORTA);
    borrador.establecerMaterial(Material.ALGODON);
    borrador.establecerColorPrincipal(Color.BLUE);
    return borrador.crearPrenda();
  }

}

