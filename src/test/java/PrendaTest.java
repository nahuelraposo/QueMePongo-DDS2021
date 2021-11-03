import models.prenda.Borrador;
import models.excepciones.PrendaIncompletaException;
import models.prenda.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static models.prenda.TipoPrenda.*;
import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {
    @Test
    public void laCategoriaDeLosAnteojosDeSolTieneQueSerACCESORIO() {
        assertEquals(anteojosDeSol().getTipoPrenda().getCategoria(), Categoria.ACCESORIO);
    }

    @Test
    public void laCategoriaDeLaRemeraMangaCortaTieneQueSerPARTESUPERIOR() {
        assertEquals(remeraMangasCortasAzul().getTipoPrenda().getCategoria(), Categoria.PARTE_SUPERIOR);
    }

    @Test
    public void zapatillasConverseTieneQueTirarNullPorMaterialNoSeteado() {
        assertThrows(PrendaIncompletaException.class,()->{zapatillasConverse();});
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
