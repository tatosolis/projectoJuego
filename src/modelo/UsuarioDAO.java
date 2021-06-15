package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO implements ConsultasDAO {

    @Override
    public void insertar(UsuarioVO u) {
        Conector c = new Conector();
        UsuarioVO uvo = new UsuarioVO();
        try {
            c.conectar();
            String consulta = "exec InsertaUsuario '" + uvo.getNombre_usuario() + "', '" + uvo.getApellido_usuario() + "', '" + uvo.getUsuario() + "', '" + uvo.getPassword() + "';";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.err.println("mensaje insertar: " + e.getMessage());
        }
        c.desconectar();

    }

    @Override
    public void modificar(UsuarioVO u) {
        Conector c = new Conector();
        UsuarioVO uvo = new UsuarioVO();
        try {
            c.conectar();
            String consulta = "exec ModificaUsuario '" + uvo.getNombre_usuario() + "', '" + uvo.getApellido_usuario() + "', '" + uvo.getUsuario() + "', '" + uvo.getPassword() + "';";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.err.println("mensaje insertar: " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void eliminar(UsuarioVO u) {
        Conector c = new Conector();
        UsuarioVO uvo = new UsuarioVO();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_usuario where idusuario =  " + uvo.getId_usuario()+";";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.err.println("mensaje Eliminar usuario: " + e.getMessage());
            }
        c.desconectar();
    }

    @Override
    public ArrayList<UsuarioVO> consultarTablaUsuario() {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList<>();
         UsuarioVO uvo = new UsuarioVO();
          try {
            c.conectar();
            String consulta = "Exec TablaUsuarios";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                UsuarioVO vo = new UsuarioVO();
                vo.setId_usuario(rs.getInt(1));
                vo.setNombre_usuario(rs.getString(2));
                vo.setApellido_usuario(rs.getString(3));
                vo.setUsuario(rs.getString(4));
                vo.setPassword(rs.getString(5));
                vo.setId_estado(rs.getInt(6));
                vo.setId_tipo_usuario(rs.getInt(7));
                vo.setNombre_tipo_usuario(rs.getString(8));
                vo.setPunteo_score(rs.getInt(9));
                info.add(vo);

            }
            c.desconectar();

        } catch (Exception e) {
            System.err.println("error en consulta " + e.getMessage());
        }
        return info;
     }

//    public int validausuario(UsuarioVO u) {
//        int resultado = 0;
//        Conector c = new Conector();
//        try {
//            c.conectar();
//            String consulta = "SELECT * FROM tbl_usuario WHERE usuario = '"+u.getUsuario()+"' and  password = '"+u.getPassword()+"';";
//            ResultSet rs = c.consulta_datos(consulta);
//            if (rs.next()){
//                resultado = 1;
//                c.desconectar();
//            }else {
//                System.err.println("Error en consulta de datos");
//            }
//        } catch (Exception e) {
//            System.err.println("Error de conexion"+e.getMessage());
//        }
//        return resultado;
//    
//    }
    @Override
    public ArrayList<UsuarioVO> validausuario() {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList<>();
        UsuarioVO uvo = new UsuarioVO();
        try {
            c.conectar();
            String consulta = "exec validaUsuario '" + uvo.getUsuario() + "', '" + uvo.getPassword() + "';";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                UsuarioVO vo = new UsuarioVO();
                vo.setId_usuario(rs.getInt(1));
                vo.setNombre_usuario(rs.getString(2));
                vo.setApellido_usuario(rs.getString(3));
                vo.setUsuario(rs.getString(4));
                vo.setPassword(rs.getString(5));
                vo.setId_estado(rs.getInt(6));
                vo.setId_tipo_usuario(rs.getInt(7));
                vo.setNombre_tipo_usuario(rs.getString(8));
                vo.setPunteo_score(rs.getInt(9));
                info.add(vo);

            }
            c.desconectar();

        } catch (Exception e) {
            System.err.println("error en consulta " + e.getMessage());
        }
        return info;

    }

}
