
package modelo;

import java.util.ArrayList;


public interface ConsultasDAO {
    public ArrayList<UsuarioVO> validausuario();
    public void insertar(UsuarioVO u);
    public void modificar(UsuarioVO u);
    public void eliminar(UsuarioVO u);
    public ArrayList<UsuarioVO> consultarTablaUsuario();
    
}
