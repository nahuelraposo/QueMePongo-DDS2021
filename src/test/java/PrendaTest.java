import dominio.Borrador;
import dominio.excepciones.PrendaIncompletaException;
import dominio.prenda.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static dominio.prenda.TipoPrenda.*;
import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {
    @Test
    public void laCategoriaDeLosAnteojosDeSolEsAccesorio() {
        assertEquals(anteojosDeSol().getTipoPrenda().getCategoria(), Categoria.ACCESORIO);
    }

    @Test
    public void laCategoriaDeLaRemeraMangaCortaEsParteSuperior() {
        assertEquals(remeraMangasCortasAzul().getTipoPrenda().getCategoria(), Categoria.PARTE_SUPERIOR);
    }

    @Test
    public void elMaterialDeLasZapatillasConverseEsNullYTiraException() {
        assertThrows(PrendaIncompletaException.class,()->{zapatillasConverse();});
    }

    //MOCKITOS
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

    private Prenda zapatillasConverse(){
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(ZAPATILLAS);
        borrador.establecerColorPrincipal(Color.white);
        return borrador.crearPrenda();
    }

    private Prenda polleraAmarilla(){
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(POLLERA);
        borrador.establecerMaterial(Material.LYCRA);
        borrador.establecerColorPrincipal(Color.YELLOW);
        return borrador.crearPrenda();
    }
}
