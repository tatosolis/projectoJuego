
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conector {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=juego";
    private String servidor = "localhost:1433";
    private String usuario = "reporte";
    private String password = "2021";
    private String bd = "juego";
    private String cadena;

    Connection con;
    //Declarar objeto que permite realizar consultas sql insert, update, delete
    Statement st;
    
    public void conectar(){
           this.cadena = "jdbc:sqlserver://" + this.servidor + ";" + this.bd;

        try {
            Class.forName(driver).newInstance();
            this.con = DriverManager.getConnection(this.url, this.usuario, this.password);

        } catch (Exception e) {
            System.err.println("Error al conectar");
        }
    }
    
    public void desconectar(){
          try {
            this.con.close();
        } catch (Exception e) {
            System.err.println("Mensaje 2" + e.getMessage());
        }
    }
    
    public int consultas_multiples(String consulta) {
        int resultado;

        try {
            this.conectar();
            this.st = this.con.createStatement();
            resultado = this.st.executeUpdate(consulta);
        } catch (Exception e) {
            System.err.println("Mensaje 3 " + e.getMessage());
            return 0;
        } finally {
            this.desconectar();
        }
        
        return resultado;
    }
    
     //metodo para obtener data
    public ResultSet consulta_datos(String consulta){
        try{
            this.conectar();
            ResultSet resultado = null;
            this.st = this.con.createStatement();
            resultado = st.executeQuery(consulta);
            return resultado;
            
        }catch(Exception e){
            System.err.println("Mensaje 4: "+ e.getMessage());
            
        }
  return null;
    }
    
}
