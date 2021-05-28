package dominio.guardarropa;

import dominio.prenda.Prenda;

import java.util.ArrayList;
import java.util.List;

public class GuardarropaCompartido {
    private final static GuardarropaCompartido INSTANCE = new GuardarropaCompartido();
    private static final List<Prenda> prendas = new ArrayList<>();

    public static GuardarropaCompartido getInstance() {
        return INSTANCE;
    }

    public void agregarNuevaPrenda(Prenda prenda) {
        prendas.add(prenda);
    }


}
