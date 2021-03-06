package dominio.guardarropa;

import dominio.Usuario;
import dominio.excepciones.GuardarropaIncorrectoException;
import dominio.prenda.Prenda;

import java.util.List;

public class Guardarropa {
    List<Prenda> prendas;

    public Guardarropa(List<Prenda> prendas){
        this.prendas = prendas;
    }

    public void agregarPrendaRecomendada(Usuario usuario,Prenda prenda){
        if(usuario.getGuardarropas().contains(this)){
            prendas.add(prenda);
        }
        else
            throw new GuardarropaIncorrectoException();
    }

    public void quitarPrendaRecomendada(Usuario usuario,Prenda prenda) {
        if(usuario.getGuardarropas().contains(this)){
            prendas.remove(prenda);
        }
        else
            throw new GuardarropaIncorrectoException();
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

}
