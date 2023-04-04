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

    public ArrayList<Materia> getMateriasAprobadas(){
        return this.materiasAprobadas;
    }

    public boolean aproboMateria(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }

    public void setMateriasAprobadas(Materia materia){
        if(!materia.puedeCursar(this)) {
            throw new MismaMateriaException(this.nombre + " no puede aprobar la materia " + materia.getNombre() + " porque le faltan una o mas correlativas");
        }
        this.materiasAprobadas.add(materia);
    }

    public String getNombre(){
        return this.nombre;
    }

}
