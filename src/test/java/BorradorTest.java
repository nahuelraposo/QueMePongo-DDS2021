import dominio.Borrador;
import dominio.prenda.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static dominio.prenda.TipoPrenda.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BorradorTest {
    @Test
    public void laTramaDeLaRemeraEsLISA() {
        assertEquals(prenda1().getTrama(), Trama.LISA);
    }

    @Test
    public void elMaterialDelBorrador2esNuloYTiraExcepcion() {
        assertThrows(RuntimeException.class,()->{prenda2();});
    }

    @Test
    public void tiraErrorPorqueElTipoPrendaAunNoSeAclaro() {
        assertThrows(RuntimeException.class,()->{prenda3();});
    }

    //MOCKITOS
    private Prenda prenda1(){
        Borrador borrador1 = new Borrador();
        borrador1.establecerTipoPrenda(REMERA_MANGA_CORTA);
        borrador1.establecerMaterial(Material.ALGODON);
        borrador1.establecerColorPrincipal(Color.YELLOW);
        return borrador1.crearPrenda();
    }

    private Prenda prenda2(){
        Borrador borrador2 = new Borrador();
        borrador2.establecerTipoPrenda(REMERA_MANGA_CORTA);
        borrador2.establecerColorPrincipal(Color.YELLOW);
        return borrador2.crearPrenda();
    }

    private Prenda prenda3(){
        Borrador borrador3 = new Borrador();
        borrador3.establecerMaterial(Material.ALGODON);
        borrador3.establecerTipoPrenda(REMERA_MANGA_CORTA);
        borrador3.establecerColorPrincipal(Color.YELLOW);
        return borrador3.crearPrenda();
    }


}
