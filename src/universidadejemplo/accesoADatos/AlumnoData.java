package universidadejemplo.accesoADatos;

import java.sql.*;
import universidadejemplo.Entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;


public class AlumnoData {

    private Connection con=null;

    public AlumnoData() {
       con = miConexion.getConexion();//me conecto a la base
       
    }
    
    public void guardarAlumno(Alumno alumno){
        
        
        String sql="INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, `fecha_nac`, `estado`) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4,alumno.getFecha_nacimiento());
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                
                alumno.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Alumno Guardado");
                
            }  

            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla alumno");
        }
          
    }
}