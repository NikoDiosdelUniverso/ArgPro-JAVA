package org.example;

import org.example.Excepciones.MismaMateriaException;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    String nombre;
    List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean puedeCursar(Alumno alumno) {

        if (alumno.aproboMateria(this)) {
            throw new MismaMateriaException("El alumno " + alumno.getNombre() + " no puede cursar la materia " + this.nombre + " porque ya fue aprobada");
        }

        for (Materia correlativa : correlativas) {
            if (!alumno.aproboMateria(correlativa)) {
                return false;
            }
        }
        return true;
    }

    public void setCorrelativas(Materia materia) {
        if (materia.getNombre().equals(this.nombre)) {
            throw new MismaMateriaException("Una materia no puede ser correlativa de si misma");
        }
        if (this.correlativas.contains(materia)) {
            throw new MismaMateriaException("La materia " + materia.getNombre() + " ya es correlativa de " + this.nombre);
        }
        this.correlativas.add(materia);
    }
}
