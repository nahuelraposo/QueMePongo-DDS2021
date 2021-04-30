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
        return new Prenda(ANTEOJOS,Material.PLASTICO, Color.YELLOW,null,null);
    }

    private Prenda remeraMangasCortasAzul(){
        return new Prenda(REMERA_MANGA_CORTA, Material.ALGODON, Color.BLUE,null,null);
    }

    private Prenda zapatillasConverse(){
        return new Prenda(ZAPATILLAS, null, Color.white,null,null);
    }

    private Prenda polleraAmarilla(){
        return new Prenda(POLLERA, Material.LYCRA, Color.YELLOW,null,null);
    }
}
