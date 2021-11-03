package models.guardarropa;

import models.Usuario;

public interface Recomendacion {

    public void ejecutar(Usuario usuario);

    public void deshacer(Usuario usuario);
}
