package dominio.guardarropa;

import dominio.Usuario;
import dominio.excepciones.GuardarropaIncorrectoException;
import dominio.prenda.Prenda;

public class RecomendarQuitar implements Recomendacion {
    Prenda prendaARecomendar;

  public RecomendarQuitar(Prenda prenda){
    this.prendaARecomendar = prenda;
  }
    public void ejecutar(Usuario usuario,Guardarropa guardarropa){
            if(usuario.getGuardarropas().contains(guardarropa)){
                guardarropa.quitarPrenda(prendaARecomendar);
            }
            else
                throw new GuardarropaIncorrectoException();
    }

    @Override
    public void deshacer(Usuario usuario, Guardarropa guardarropa){}

}
