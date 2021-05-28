package dominio.guardarropa;

import dominio.prenda.Prenda;

import java.util.List;

public class Guardarropa {
    List<Prenda> prendas;

    public Guardarropa(List<Prenda> prendas){
        this.prendas = prendas;
    }

    public void agregarPrenda(Prenda prenda){
        prendas.add(prenda);
    }

    public void quitarPrenda(Prenda prenda) {
        prendas.remove(prenda);
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

}
