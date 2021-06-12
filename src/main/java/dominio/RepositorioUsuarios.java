package dominio;

import dominio.proveedorDeClima.RegistroAlertas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
  private final static RepositorioUsuarios INSTANCE = new RepositorioUsuarios();
  private List<Usuario> usuarios = new ArrayList<>();
  private RegistroAlertas registroAlertas;

  public static RepositorioUsuarios getInstance() {
    return INSTANCE;
  }

  public void agregarUsuario(Usuario usuario){
    usuarios.add(usuario);
  }

  public void actualizarSugerenciasDiariasDeUsuarios(){
    usuarios.forEach(usuario -> usuario.actualizarAtuendosDiariosSugeridos());
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }
}
