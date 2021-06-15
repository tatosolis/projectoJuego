
package proyectojuego;

import controlador.ControladorLogin;
import controlador.ControladorUsuario;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.Frm_Avanzado;
import vista.Frm_Login;
import vista.Frm_Menu;
import vista.Frm_Usuarios;

public class ProyectoJuego {


    public static void main(String[] args) {
        //Implementacion de vistas
        Frm_Menu m = new Frm_Menu();
        Frm_Login l = new Frm_Login();
        Frm_Usuarios u = new Frm_Usuarios();
        Frm_Avanzado a = new Frm_Avanzado();
        
        //implementacion de datos
        UsuarioVO uvo = new UsuarioVO();
        UsuarioDAO udao = new UsuarioDAO();
        
        
        //controladores
        ControladorLogin cl = new ControladorLogin( l, uvo,  udao);
        ControladorUsuario cu = new ControladorUsuario(u,uvo,  udao);
        
        
        //Levanta primera pantalla login 
        u.setVisible(true);
        l.setVisible(true);
        l.setLocationRelativeTo(l);
        
        
        
        
    }
    
}
