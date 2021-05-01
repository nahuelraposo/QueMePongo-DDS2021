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

    @Test
    public void tiraErrorPorqueUnaRemeraNoAdmiteMaterialCuero() {
        assertThrows(RuntimeException.class,()->{prenda4();});
    }


    //MOCKITOS
    private Prenda prenda1(){
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(REMERA_MANGA_CORTA);
        borrador.establecerMaterial(Material.ALGODON);
        borrador.establecerColorPrincipal(Color.YELLOW);
        return borrador.crearPrenda();
    }

    private Prenda prenda2(){
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(REMERA_MANGA_CORTA);
        borrador.establecerColorPrincipal(Color.YELLOW);
        return borrador.crearPrenda();
    }

    private Prenda prenda3(){
        Borrador borrador = new Borrador();
        borrador.establecerMaterial(Material.ALGODON);
        borrador.establecerTipoPrenda(REMERA_MANGA_CORTA);
        borrador.establecerColorPrincipal(Color.YELLOW);
        return borrador.crearPrenda();
    }

    private Prenda prenda4(){
        Borrador borrador = new Borrador();
        borrador.establecerTipoPrenda(REMERA_MANGA_CORTA);
        borrador.establecerMaterial(Material.CUERO);
        borrador.establecerColorPrincipal(Color.YELLOW);
        return borrador.crearPrenda();
    }


}
