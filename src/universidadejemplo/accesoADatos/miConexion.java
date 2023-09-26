package universidadejemplo.accesoADatos;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class miConexion {
    private static final String URL="jdbc:mariadb://localhost/ulpfunc";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static miConexion conexion=null;
   
     public miConexion(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "no se puede establecer la conexion" +ex);
        }
        
    }
    public static Connection getConexion(){
        Connection con=null;
        if(conexion==null){
            conexion=new miConexion();
            System.out.println("Funciona!!!");
        }
        try {
            con=DriverManager.getConnection(URL,USUARIO,PASSWORD);
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de conexion " +ex);
        }
        return con;
    }
    }


//public class miConexion {
//    private static final String URL="jdbc:mariadb://localhost/";
//    private static final String DB="universidad_ulp";
//    private static final String USUARIO="root";
//    private static final String PASSWORD="";
//    
//    private static miConexion conexion=null;
//
//   public miConexion(){
//        
//    }    
//    
//   public static Connection getConexion(){
//       
//     if(connection == null){
//         
//         try {
//             Class.forName("org.mariadb.jdbc.Driver");
//             //connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
//             
//             connection = DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" +
//                            "&user=" + USUARIO + "&password=" + PASSWORD);
//             
//         } catch (ClassNotFoundException ex) {
//             JOptionPane.showMessageDialog(null,"Error al cargar los drivers");
//           } catch (SQLException ex) {
//             JOptionPane.showMessageDialog(null,"Error al conectarse");
//           } 
//         
//        }  
//        return connection;
//   }
//}
