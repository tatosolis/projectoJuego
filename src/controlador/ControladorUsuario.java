
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.Frm_Usuarios;


public class ControladorUsuario implements ActionListener, MouseListener, WindowListener{
    Frm_Usuarios vista = new Frm_Usuarios();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    
    public ControladorUsuario (Frm_Usuarios vista, UsuarioVO uvo,UsuarioDAO udao){
        this.vista = vista;
        this.udao = udao;
        this.uvo = uvo;
        vista.addWindowListener(this);
        vista.Btn_Agregar.addActionListener(this);
        vista.Btn_Eliminar.addActionListener(this);
        vista.Btn_Modificar.addActionListener(this);
        vista.Btn_Salir.addActionListener(this);
        
    }
    private void mostrar(){
         DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("IdUsuario");
        m.addColumn("NombreUsuario");
        m.addColumn("ApellidoUsuario");
        m.addColumn("usuario");
        m.addColumn("password");
        m.addColumn("id_estado");
        m.addColumn("id_tipo_usuario");
        m.addColumn("tipo_usuario");
        m.addColumn("punteo_score");
        
        
        for (UsuarioVO uvo : udao.consultarTablaUsuario()) {
            m.addRow(new Object[]{uvo.getId_usuario(), uvo.getNombre_usuario(), uvo.getApellido_usuario(), uvo.getUsuario(),
                uvo.getPassword(), uvo.getId_usuario(), uvo.getId_tipo_usuario(), uvo.getNombre_tipo_usuario(),uvo.getPunteo_score()});
        }
        vista.Tbl_Usuarios.setModel(m);
    }
    private void InsertarUsuario(){
        uvo.setNombre_tipo_usuario(vista.Txt_Nombre.getText());
        uvo.setApellido_usuario(vista.Txt_Apellido.getText());
        uvo.setUsuario(vista.Txt_Usuario.getText());
        uvo.setPassword(vista.Txt_Password.getText());
        udao.insertar(uvo);
        
    }
    
    private void ModificarUsuario(){
            uvo.setNombre_tipo_usuario(vista.Txt_Nombre.getText());
        uvo.setApellido_usuario(vista.Txt_Apellido.getText());
        uvo.setUsuario(vista.Txt_Usuario.getText());
        uvo.setPassword(vista.Txt_Password.getText());
        udao.modificar(uvo);
    }
    
    private void EliminarUsuario(){
        uvo.setId_usuario(Integer.parseInt(vista.Txt_idusuario.getText()));
        udao.eliminar(uvo);
    }
    
     private void limpiaCampos() {
        vista.Txt_Nombre.setText("");
        vista.Txt_Apellido.setText("");
        vista.Txt_Usuario.setText("");
        vista.Txt_Password.setText("");
    }
     
     private void llenarCampos(){
         int seleccion = vista.Tbl_Usuarios.getSelectedRow();
         vista.Txt_Nombre.setText(String.valueOf(vista.Tbl_Usuarios.getValueAt(seleccion, 1)));
         vista.Txt_Apellido.setText(String.valueOf(vista.Tbl_Usuarios.getValueAt(seleccion, 2)));
         vista.Txt_Usuario.setText(String.valueOf(vista.Tbl_Usuarios.getValueAt(seleccion, 3)));
         vista.Txt_Password.setText(String.valueOf(vista.Tbl_Usuarios.getValueAt(seleccion, 4)));
     
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.Btn_Agregar) {
            this.InsertarUsuario();
            this.limpiaCampos();
            this.mostrar();
        }
        
          if (ae.getSource() == vista.Btn_Modificar) {
            this.ModificarUsuario();
            this.limpiaCampos();
            this.mostrar();
          }
          
          if (ae.getSource() == vista.Btn_Eliminar) {
            this.EliminarUsuario();
            this.limpiaCampos();
            this.mostrar();
          }
          
          if (ae.getSource()== vista.Btn_Refresh){
              this.mostrar();
          }
          
          if (ae.getSource() == vista.Btn_Salir) {
            vista.dispose();
          }
     }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.llenarCampos();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.mostrar();
   }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
}
