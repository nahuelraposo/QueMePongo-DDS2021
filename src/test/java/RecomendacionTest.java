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
  Usuario usuario = new Usuario(guardarropas, null, null,new ArrayList<>(),null,null,null,null,null);
  Prenda anteojosDeSol = anteojosDeSol();
  Prenda remeraMangasCortasAzul = remeraMangasCortasAzul();

  Recomendacion recomendarAgregar = new RecomendarAgregar(anteojosDeSol,guardarropa);
  Recomendacion recomendarQuitar = new RecomendarQuitar(remeraMangasCortasAzul,guardarropa);

  @BeforeEach
  void setup() {
    usuario.agregarGuardarropa(guardarropa);
  }

  @Test
  public void unaRecomendacionAgregarSeAceptayLaPrendaIngresaAlGuardarropa() {
      usuario.agregarRecomendacion(recomendarAgregar);
      usuario.aceptarRecomendacion(recomendarAgregar);

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
    usuario.aceptarRecomendacion(recomendarAgregar);
    usuario.deshacerRecomendacion(recomendarAgregar);

    Assertions.assertFalse(guardarropa.getPrendas().contains(anteojosDeSol));
  }

  @Test
  public void unaRecomendacionQuitarSeAceptayLaPrendaSaleDelGuardarropa() {
    guardarropa.agregarPrendaRecomendada(usuario,remeraMangasCortasAzul);
    usuario.agregarRecomendacion(recomendarQuitar);
    usuario.aceptarRecomendacion(recomendarQuitar);

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

