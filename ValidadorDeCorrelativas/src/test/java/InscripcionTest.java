import org.example.Alumno;
import org.example.Inscripcion;
import org.example.Materia;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InscripcionTest {

    //una materia sin correlativas
    @Test
    public void aprobadaTest() {
        ArrayList<Materia> materias = new ArrayList<>();
        Materia materia1 = new Materia("materia1", materias);
        Alumno alumno1 = new Alumno("nombre1", materias);
        Inscripcion inscripcion1 = new Inscripcion(alumno1, materia1);
        assertTrue(inscripcion1.aprobada());
    }

    //una materia con correlativas y que el alumno las tenga
    @Test
    public void aprobadaConCorrelativaTest() {
        ArrayList<Materia> materias = new ArrayList<>();
        ArrayList<Materia> materiasCorrelativas = new ArrayList<>();

        Materia materia1 = new Materia("materia1", materias);
        materiasCorrelativas.add(materia1);
        Materia materia2 = new Materia("materia2", materiasCorrelativas);
        Alumno alumno2 = new Alumno("nombre2", materiasCorrelativas);
        Inscripcion inscripcion2 = new Inscripcion(alumno2, materia2);
        assertTrue(inscripcion2.aprobada());
    }


    //una materia con correlativas y que el alumno no las tenga
    @Test
    public void aprobadaSinCorrelativaTest() {
        ArrayList<Materia> ninguna = new ArrayList<>();
        ArrayList<Materia> materiasCorrelativas = new ArrayList<>();

        Materia materia1 = new Materia("materia1", ninguna);
        materiasCorrelativas.add(materia1);
        Materia materia2 = new Materia("materia2", materiasCorrelativas);

        Alumno alumno3 = new Alumno("nombre3", ninguna);
        Inscripcion inscripcion = new Inscripcion(alumno3, materia2);
        assertFalse(inscripcion.aprobada());
    }
}
