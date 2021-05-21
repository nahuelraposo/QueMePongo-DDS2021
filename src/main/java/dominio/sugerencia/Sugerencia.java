package dominio.sugerencia;

import dominio.prenda.Categoria;
import dominio.prenda.Prenda;

import java.util.List;

public class Sugerencia {
    List<Prenda> prendasSugeridas;

    public List<Prenda> getPrendasSugeridas() {
        return prendasSugeridas;
    }

    // acá basicamente lo que busco es validar que todas las prendas de cada sugerencia que se
    // le den al usuario, cumplan con que hay una prenda para cada categoria
    public boolean cumpleCondicion() {
        return prendasSugeridas.stream()
                .map(prenda -> prenda.getTipoPrenda().getCategoria())
                .distinct()
                .count() >= Categoria.values().length;
    }
}
