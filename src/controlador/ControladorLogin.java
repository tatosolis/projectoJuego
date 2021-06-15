
package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.Frm_Avanzado;
import vista.Frm_Intermedio;
import vista.Frm_Login;
import vista.Frm_Menu;
import vista.Frm_Principiante;
import vista.Frm_Usuarios;

public class ControladorLogin implements ActionListener{
  
    Frm_Login vista = new Frm_Login();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();    
    Frm_Menu m = new Frm_Menu();
    Frm_Principiante p = new Frm_Principiante();
    Frm_Intermedio i = new Frm_Intermedio();
    Frm_Avanzado a = new Frm_Avanzado();
    Frm_Usuarios us = new Frm_Usuarios();
    
    public ControladorLogin (Frm_Login vista,UsuarioVO uvo,UsuarioDAO udao ){
        this.vista = vista;
        this.uvo = uvo;
        this.udao = udao;
        vista.Btn_Ingresar.addActionListener(this);
        vista.Btn_Salir.addActionListener(this);
        
        
    }
    private void logear() {
        int resultado = 0;
        String Usuariorecupera = null ;
        String Passrecupera;
        String tipoUsuario;
        int punteo = 0;
        uvo.setUsuario(vista.Txt_Usuario.getText());
        uvo.setPassword(vista.Jpa_password.getText());
        udao.validausuario();
        
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
        
        
        for (UsuarioVO uvo : udao.validausuario()) {
            m.addRow(new Object[]{uvo.getId_usuario(), uvo.getNombre_usuario(), uvo.getApellido_usuario(), uvo.getUsuario(),
                uvo.getPassword(), uvo.getId_usuario(), uvo.getId_tipo_usuario(), uvo.getNombre_tipo_usuario(),uvo.getPunteo_score(),
            Usuariorecupera=uvo.getUsuario()});
        }
//        DefaultTableModel tableModel = new DefaultTableModel(5,9);
//        JTable jt = new JTable(tableModel);
//        jt.getTableHeader().setResizingAllowed(false);
//        Dimension dim = new Dimension(5,9);
//        jt.setIntercellSpacing(new Dimension(dim));
//        jt.setModel(m);
//        
//        Object ob = m.getDataVector().get(1);
//        //Object ob = m.getValueAt(0, 2);
        JOptionPane.showMessageDialog(null,"valor retornado "+ Usuariorecupera);
        
        us.setVisible(true);
        vista.dispose();
        
        
//        if(udao.validausuario(uvo)==1){
//             us.setVisible(true);
//            vista.dispose();
//        }
//
//        else
//        {JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INVÁLIDO");
//           }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.Btn_Ingresar){
            this.logear();
        }
         if(ae.getSource()==vista.Btn_Salir){
            vista.dispose();
            
        }
        
    }

 
}
