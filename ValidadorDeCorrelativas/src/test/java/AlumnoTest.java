import org.example.Alumno;
import org.example.Excepciones.MismaMateriaException;
import org.example.Materia;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlumnoTest {

    private Materia materia1;
    private Materia materia2;
    private Materia materia3;
    private Materia materia4;
    private Alumno alumno;

    @Before
    public void init() {
        this.materia1 = new Materia("materia 1");
        this.materia2 = new Materia("Materia 2");
        this.materia3 = new Materia("Materia 3");
        this.materia4 = new Materia("Materia 4");
        materia2.setCorrelativas(materia1);
        materia3.setCorrelativas(materia2);
        materia4.setCorrelativas(materia1);
        this.alumno = new Alumno("un alumno");
        alumno.setMateriasAprobadas(materia1);
    }
    @Test
    public void aproboMateriaTest(){
    assertTrue(alumno.aproboMateria(materia1));
    assertFalse(alumno.aproboMateria(materia2));
    }
    @Test
    public void agregarMateriaYaAprobada(){
    assertThrows(MismaMateriaException.class, () -> alumno.setMateriasAprobadas(materia1));
    }

    @Test
    public void agregarMateriaSinCorrelativaAprobada(){
    assertThrows(RuntimeException.class, ()-> alumno.setMateriasAprobadas(materia3));
    }

    @Test
    public void agregarMateriaNoAprobadaPreviamente(){
    alumno.setMateriasAprobadas(materia2);
    assertTrue(alumno.aproboMateria(materia2));
    }
}
