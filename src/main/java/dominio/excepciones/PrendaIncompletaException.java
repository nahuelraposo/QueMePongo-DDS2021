package dominio.excepciones;

public class PrendaIncompletaException extends RuntimeException {

    public PrendaIncompletaException() {
        super("La asignacion del tipo, del material, y del color principal de la prenda es obligatoria.");
    }

}
