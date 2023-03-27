package org.example;

public class Inscripcion {
    Alumno alumno;
    Materia materia;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }

    public boolean aprobada() {
        return this.materia.puedeCursar(this.alumno);
    }
}
