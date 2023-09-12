/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo;

import java.sql.Connection;
import universidadejemplo.accesoADatos.miConexion;

/**
 *
 * @author Luciano Chalfon
 */
public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Hola mundoo !!!
        Connection con=miConexion.getConexion();
    }
    
}
