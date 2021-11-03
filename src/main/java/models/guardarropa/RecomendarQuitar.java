package models.guardarropa;

import models.Usuario;
import models.prenda.Prenda;

public class RecomendarQuitar implements Recomendacion {
    Prenda prendaARecomendar;
    Guardarropa guardarropa;

  public RecomendarQuitar(Prenda prenda,Guardarropa guardarropa){
    this.prendaARecomendar = prenda;
    this.guardarropa = guardarropa;
  }
    public void ejecutar(Usuario usuario){
                getGuardarropa().quitarPrendaRecomendada(usuario,prendaARecomendar);
    }

    public void deshacer(Usuario usuario){}

  public Guardarropa getGuardarropa() {
    return guardarropa;
  }
}
