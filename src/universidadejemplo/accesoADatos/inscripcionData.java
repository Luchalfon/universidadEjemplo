package universidadejemplo.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;

public class inscripcionData {

    private Connection con = null;
    private materiaData md = new materiaData();
    private AlumnoData ad = new AlumnoData();

    public inscripcionData() {
        this.con = miConexion.getConexion();//me conecto a la base

    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion(id_alumno, id_materia, nota) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getId_alumno());
            ps.setInt(2, insc.getMateria().getId_materia());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                insc.setId_inscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción registrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE inscripcion SET nota=? WHERE id_alumno=? and id_materia=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
    }

    public void borrarInscripcionAlumnoMateria(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE id_alumno=? and id_materia=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Inscripcion borrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
    }
    

    public List<Inscripcion> obtenerInscripciones() {

        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {

                Inscripcion insc = new Inscripcion();
                insc.setId_inscripcion(rs.getInt("id_inscripto"));
                Alumno alu = this.ad.buscarAlumnoPorID(rs.getInt("Id_alumno"));
                Materia mat = this.md.buscarMateriaPorID(rs.getInt("Id_materia"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
        return cursadas;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {

        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE id_alumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {

                Inscripcion insc = new Inscripcion();
                insc.setId_inscripcion(rs.getInt("id_inscripto"));
                Alumno alu = ad.buscarAlumnoPorID(rs.getInt("Id_alumno"));
                Materia mat = md.buscarMateriaPorID(rs.getInt("Id_materia"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
        return cursadas;
    }

    public List<Materia> obtenerMateriasCursadas(int id_alumno) {

        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT inscripcion.id_materia, nombre, año FROM inscripcion,"
                + " materia WHERE inscripcion.id_materia = materia.id_materia "
                + " AND inscripcion.id_alumno = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_alumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {

                Materia materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
        return materias;
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int id_alumno) {

        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT * FROM materia WHERE estado = 1 AND id_materia not in"
                    +"(SELECT id_materia FROM inscripcion WHERE id_alumno =?)";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_alumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {

                Materia materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
        return materias;
    }
    
    public List<Alumno> obtenerAlumnoxMaterias(int id_materia){
        
        ArrayList<Alumno> alumnosMateria=new ArrayList<>(); 
        
        String sql ="SELECT alumno.id_alumno,dni,nombre,apellido,fecha_nacimiento,estado FROM inscripcion,alumno WHERE inscripcion.id_alumno=alumno.id_alumno AND inscripcion.id_materia=? AND alumno.estado=1;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_materia);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                
                Alumno alumno=new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                alumno.setEstado(true);
                alumnosMateria.add(alumno);
                
                
            }
            
      
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripción");
        }
        return alumnosMateria;
    }
}

