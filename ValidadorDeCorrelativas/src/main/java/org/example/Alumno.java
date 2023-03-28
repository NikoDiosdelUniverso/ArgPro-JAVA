package org.example;

import org.example.Excepciones.MismaMateriaException;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public boolean aproboMateria(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }

    public void setMateriasAprobadas(Materia materia){
        if(materiasAprobadas.contains(materia)) {
            throw new MismaMateriaException("La materia " + materia.getNombre() + " ya es una materia aprobada del alumno " + this.nombre);
        }
        if(!materia.puedeCursar(this)) {
            throw new RuntimeException(this.nombre + " no puede aprobar la materia " + materia.getNombre() + " porque le faltan una o mas correlativas");
        }
        this.materiasAprobadas.add(materia);
    }

    public String getNombre(){
        return this.nombre;
    }

}
