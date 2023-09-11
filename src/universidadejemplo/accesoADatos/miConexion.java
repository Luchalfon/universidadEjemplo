
package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class miConexion {
    private static final String URL="jdbd:mariadb://localhost:3306/";
    private static final String DB="universidad_ulp";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    
    private static Connection connection;

   private miConexion(){
        
    }    
    
   public static Connection getConexion(){
       
     if(connection == null){
         
         try {
             Class.forName("org.mariadb.jdbc.Driver");
             //connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
             
             connection = DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" +
                            "&user=" + USUARIO + "&password=" + PASSWORD);
             
         } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(null,"Error al cargar los drivers");
           } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al conectarse");
           }
         
        }  
        return connection;
   }
}