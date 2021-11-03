package models.excepciones;

public class SugerenciaIncompletaException extends RuntimeException{

    public SugerenciaIncompletaException() {
        super("La sugerencia debe tener al menos una prenda para cada categoria.");
    }
}
