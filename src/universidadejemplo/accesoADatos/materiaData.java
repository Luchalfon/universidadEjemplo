package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Materia;


public class materiaData {
    
private Connection con;

public materiaData() {
        con=miConexion.getConexion();//me conecto a la base
       
    }
       
  
    
    public void guardarMateria(Materia materia){
        
        
        String sql="INSERT INTO materia(nombre, año, estado) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2,materia.getAño());
            ps.setBoolean(3,materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                
                materia.setId_materia(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia Guardada");
                
            }  

            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla alumno");
        }
          
    }
}

