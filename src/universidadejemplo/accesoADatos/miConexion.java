
package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class miConexion {
    private String url;
    private String usuario;
    private String Pass;
    
    
    private static Connection conexion=null;

    public miConexion(String url, String usuario, String Pass) 
    {
        this.url = url;
        this.usuario = usuario;
        this.Pass = Pass;
        
    }    
    public Connection buscarConexion(){
        if(conexion==null){
            try  {
                
                Class.forName(url);
                conexion= DriverManager.getConnection(url,usuario,Pass);
            } catch (SQLException | ClassNotFoundException  ex) {
                Logger.getLogger(miConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              
         }       
    
         return conexion;  
    
    
    }
}