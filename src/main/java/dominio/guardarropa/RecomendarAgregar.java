package dominio.guardarropa;

import dominio.Usuario;
import dominio.excepciones.GuardarropaIncorrectoException;
import dominio.prenda.Prenda;

public class RecomendarAgregar implements Recomendacion{
    Prenda prendaARecomendar;
    Boolean aceptada = false;

    public void ejecutar(Usuario usuario,Guardarropa guardarropa){
        if(usuario.getGuardarropas().contains(guardarropa)){
            guardarropa.agregarPrenda(prendaARecomendar);
            this.aceptada = true;
        }
        else
            throw new GuardarropaIncorrectoException();
    }

    public void deshacer(Usuario usuario, Guardarropa guardarropa){
        if(usuario.getGuardarropas().contains(guardarropa)){
            guardarropa.quitarPrenda(prendaARecomendar);
        }
        else
            throw new GuardarropaIncorrectoException();
    }

}
