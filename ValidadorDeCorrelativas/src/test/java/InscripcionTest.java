import org.example.Alumno;
import org.example.Inscripcion;
import org.example.Materia;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InscripcionTest {

    //una materia sin correlativas
    @Test
    public void aprobadaTest() {
        Materia materia1 = new Materia("materia1");
        Alumno alumno1 = new Alumno("nombre1");

        Inscripcion inscripcion = new Inscripcion(alumno1, materia1);
        assertTrue(inscripcion.aprobada());
    }

    //una materia con correlativas y que el alumno las tenga
    @Test
    public void aprobadaConCorrelativaTest() {
        Materia materia1 = new Materia("materia1");
        Materia materia2 = new Materia("materia2");
        materia2.setCorrelativas(materia1);
        Alumno alumno2 = new Alumno("nombre2");
        alumno2.setMateriasAprobadas(materia1);

        Inscripcion inscripcion = new Inscripcion(alumno2, materia2);
        assertTrue(inscripcion.aprobada());
    }


    //una materia con correlativas y que el alumno no las tenga
    @Test
    public void aprobadaSinCorrelativaTest() {

        Materia materia1 = new Materia("materia1");
        Materia materia2 = new Materia("materia2");
        materia2.setCorrelativas(materia1);

        Alumno alumno3 = new Alumno("nombre3");
        Inscripcion inscripcion = new Inscripcion(alumno3, materia2);
        assertFalse(inscripcion.aprobada());
    }
}
