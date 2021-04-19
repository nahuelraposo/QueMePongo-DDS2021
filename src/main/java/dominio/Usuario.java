package dominio;

import dominio.prenda.Prenda;

import java.util.List;

public class Usuario {
    List<Prenda> guardarropas;

    public void cargarPrenda(Prenda prenda) {
        guardarropas.add(prenda);
    }

}
