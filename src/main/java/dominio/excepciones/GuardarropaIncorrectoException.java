package dominio.excepciones;

public class GuardarropaIncorrectoException extends RuntimeException {
    public GuardarropaIncorrectoException(){
        super("El guardarropa no se encuentra entre los guardarropas del usuario.");
    }
}
