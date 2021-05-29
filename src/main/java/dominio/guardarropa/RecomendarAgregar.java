package dominio.guardarropa;

import dominio.Usuario;
import dominio.excepciones.GuardarropaIncorrectoException;
import dominio.prenda.Prenda;

public class RecomendarAgregar implements Recomendacion{
    Prenda prendaARecomendar;
    Boolean aceptada = false;
    Guardarropa guardarropa;

    public RecomendarAgregar(Prenda prenda,Guardarropa guardarropa){
        this.prendaARecomendar = prenda;
        this.guardarropa = guardarropa;
    }

    public void ejecutar(Usuario usuario){
            getGuardarropa().agregarPrendaRecomendada(usuario,prendaARecomendar);
            this.aceptada = true;
    }

    public void deshacer(Usuario usuario){
            getGuardarropa().quitarPrendaRecomendada(usuario,prendaARecomendar);
    }

  public Guardarropa getGuardarropa() {
    return guardarropa;
  }
}
