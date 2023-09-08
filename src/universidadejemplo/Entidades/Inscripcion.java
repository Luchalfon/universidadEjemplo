
package universidadejemplo.Entidades;


public class Inscripcion {
    private int id_inscripcion;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion() {
    }

    public Inscripcion(double nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(int id_inscripcion, double nota, Alumno alumno, Materia materia) {
        this.id_inscripcion = id_inscripcion;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "inscripcion{" + "id_inscripcion=" + id_inscripcion + ", nota=" + nota + ", alumno=" + alumno + ", materia=" + materia + '}';
    }
    
    
    
}
