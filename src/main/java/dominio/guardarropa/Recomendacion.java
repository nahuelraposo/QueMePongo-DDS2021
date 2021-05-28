package dominio.guardarropa;

import dominio.Usuario;
import dominio.prenda.Prenda;

public interface Recomendacion {

    public void ejecutar(Usuario usuario,Guardarropa guardarropa);

    public void deshacer(Usuario usuario, Guardarropa guardarropa);
}
