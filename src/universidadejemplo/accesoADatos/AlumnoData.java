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

    private Connection con = null;

    public AlumnoData() {
        con = miConexion.getConexion();//me conecto a la base

    }

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, `fecha_nacimiento`, `estado`) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, alumno.getFecha_nacimiento());
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                alumno.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Guardado");

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla alumno");
        }

    }

    public void eliminarAlumno(int id) {
        try {
            String sql = "UPDATE alumno SET estado = 0 WHERE id_alumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }

    }

    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;
        String sql = "SELECT id_alumno, dni, apellido, nombre, fecha_nacimiento FROM alumno WHERE dni=? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                alumno.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }

        return alumno;
    }

    public Alumno buscarAlumnoPorID(int id) {
        Alumno alumno = null;
        String sql = "SELECT dni, apellido, nombre, fecha_nacimiento FROM alumno WHERE id_alumno = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId_alumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                alumno.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());

        }

        return alumno;
    }

    public void modificarAlumno(Alumno alumno) {

        String sql = "UPDATE alumno SET dni = ? , apellido = ?, nombre = ?, fecha_nacimiento = ? WHERE id_alumno = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, alumno.getFecha_nacimiento());
            ps.setInt(5, alumno.getId_alumno());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }

    }
 
   public List<Alumno> listarAlumnos() {

 List<Alumno> alumnos = new ArrayList<>();
 try {
 String sql = "SELECT * FROM alumno WHERE estado = 1 ";
 PreparedStatement ps = con.prepareStatement(sql);
 ResultSet rs = ps.executeQuery();
 while (rs.next()) {
 Alumno alumno = new Alumno();

 alumno.setId_alumno(rs.getInt("id_alumno"));
 alumno.setDni(rs.getInt("dni"));
 alumno.setApellido(rs.getString("apellido"));
 alumno.setNombre(rs.getString("nombre"));
 alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
 alumno.setEstado(rs.getBoolean("estado"));
 alumnos.add(alumno);
 }
 ps.close();


 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
 }
 return alumnos;
 } 
    
}
