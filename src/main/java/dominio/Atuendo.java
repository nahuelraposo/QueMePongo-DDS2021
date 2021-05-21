package dominio;

import dominio.prenda.Categoria;
import dominio.prenda.Prenda;

import java.util.List;
import java.util.Map;

public class Atuendo {
    List<Prenda> atuendo;

    public List<Prenda> getAtuendo() {
        return atuendo;
    }

    // acá basicamente lo que busco es validar que todas las prendas de cada atuendo que se
    // le den al usuario, cumplan con que hay  para cada categoria
    public boolean cumpleCondicion() {
        return atuendo.stream()
                .map(prenda -> prenda.getTipoPrenda().getCategoria())
                .distinct()
                .count() >= Categoria.values().length;
    }

    public boolean aptoParaTemperatura(Map<String, Object> estadoDelTiempo) {
        return atuendo.stream().allMatch(prenda -> prenda.aptaParaTemperatura(estadoDelTiempo.get("Temperature")));
    }
}

/*
ejemplos de atuendos:

atuendo1 = new Atuendo([anteojosSol,remeraCortaAzul,pantalonMama,zapasConverse]);
atuendo2 = new Atuendo([pañuelo verde, remeraLargaRayada,jean,botasCuero]);
atuendo3 = new Atuendo([musculosaMickey,polleraAmarilla,crocs]);


 */

