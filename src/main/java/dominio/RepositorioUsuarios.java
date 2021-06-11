package dominio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
  private final static RepositorioUsuarios INSTANCE = new RepositorioUsuarios();
  private static final List<Usuario> usuarios = new ArrayList<>();

  public static RepositorioUsuarios getInstance() {
    return INSTANCE;
  }

  public void agregarUsuario(Usuario usuario){
    usuarios.add(usuario);
  }

  public void actualizarSugerenciasDiariasDeUsuarios(){
    usuarios.forEach(usuario -> usuario.actualizarAtuendosDiariosSugeridos());
  }
}
