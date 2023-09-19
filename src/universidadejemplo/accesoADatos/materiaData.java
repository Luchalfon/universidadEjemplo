package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Materia;

public class materiaData {

    private Connection con;

    public materiaData() {
        con = miConexion.getConexion();//me conecto a la base

    }

    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia(nombre, año, estado) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                materia.setId_materia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia Guardada");

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla alumno");
        }

    }

    public Materia buscarMateriaPorID(int id) {
        Materia materia = null;
        String sql = "SELECT * FROM materia WHERE id_materia=? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setId_materia(rs.getInt(id));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe materia");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }

        return materia;
    }

    public Materia buscarMateriaPorNombre(String nombre) {
        Materia materia = null;
        String sql = "SELECT id_materia, año, estado FROM materia WHERE nombre=? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
               // materia.setNombre(rs.getString(nombre));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe materia");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }

        return materia;
    }
       public List<Materia> listarMateria() {

 List<Materia> materias = new ArrayList<>();
 try {
 String sql = "SELECT * FROM materia WHERE estado = 1 ";
 PreparedStatement ps = con.prepareStatement(sql);
 ResultSet rs = ps.executeQuery();
 while (rs.next()) {
 Materia materia = new Materia();

 materia.setId_materia(rs.getInt("id_materia"));
 materia.setNombre(rs.getString("nombre"));
 materia.setAño(rs.getInt("año"));
 materia.setEstado(rs.getBoolean("estado"));
 materias.add(materia);
 }
 ps.close();


 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia "+ex.getMessage());
 }
 return materias;
 } 
    
}
