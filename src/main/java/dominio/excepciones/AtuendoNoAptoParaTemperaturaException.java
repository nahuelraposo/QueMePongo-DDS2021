package dominio.excepciones;

public class AtuendoNoAptoParaTemperaturaException extends RuntimeException{

    public AtuendoNoAptoParaTemperaturaException() {
        super("El atuendo no es apto para la temperatura.");
    }

}
