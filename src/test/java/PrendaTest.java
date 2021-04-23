import dominio.excepciones.PrendaIncompletaException;
import dominio.prenda.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
        return new Prenda(ANTEOJOS,Material.PLASTICO, Color.AMARILLO);
    }

    private Prenda remeraMangasCortasAzul(){
        return new Prenda(REMERA_MANGA_CORTA, Material.ALGODON, Color.AZUL);
    }

    private Prenda zapatillasConverse(){
        return new Prenda(ZAPATILLAS, null, Color.BLANCO);
    }

    private Prenda polleraAmarilla(){
        return new Prenda(POLLERA, Material.LYCRA, Color.AMARILLO);
    }
}
