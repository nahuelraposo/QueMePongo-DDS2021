package dominio.guardarropa;

import dominio.Usuario;
import dominio.prenda.Prenda;

public interface Recomendacion {

    public void ejecutar(Usuario usuario);

    public void deshacer(Usuario usuario);
}
