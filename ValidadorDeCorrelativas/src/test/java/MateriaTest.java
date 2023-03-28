import org.example.Alumno;
import org.example.Excepciones.MismaMateriaException;
import org.example.Materia;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MateriaTest {

    private Materia materia;
    private Materia materia1;
    private Materia materia2;
    private Materia materia3;

    private Alumno alumno1;
    private Alumno alumno2;

    @Before
    public void init() {
        this.materia = new Materia("una materia");
        this.materia1 = new Materia("materia 1");
        this.materia2 = new Materia("materia 2");
        this.materia3 = new Materia("materia 3");
        materia1.setCorrelativas(materia);
        materia2.setCorrelativas(materia1);
        materia2.setCorrelativas(materia);
        this.alumno1 = new Alumno("alumno 1");
        this.alumno2 = new Alumno("alumno 2");
        alumno1.setMateriasAprobadas(materia);
        alumno1.setMateriasAprobadas(materia1);
    }

    @Test
    public void agregarCorrelativaMismaMateria() {
    assertThrows(MismaMateriaException.class, ()-> materia.setCorrelativas(materia));
    }

    @Test
    public void agregarCorrelativaRepetida() {
    assertThrows(RuntimeException.class, ()-> materia1.setCorrelativas(materia));
    }

    @Test
    public void puedeCursarConCorrelativas() {
    assertTrue(materia2.puedeCursar(alumno1));
    assertFalse(materia1.puedeCursar(alumno2));
    }

    @Test
    public void puedeCursarMateriaSinCorrelativas() {
    assertTrue(materia3.puedeCursar(alumno1));
    assertTrue(materia3.puedeCursar(alumno2));
    }

    @Test
    public void puedeCursarMateriaAprobada() {
        assertThrows(MismaMateriaException.class, ()-> materia.puedeCursar(alumno1));
    }
}
