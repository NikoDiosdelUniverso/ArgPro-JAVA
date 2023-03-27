package org.example;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private ArrayList<Materia> materiasAprobadas;

    public Alumno(String nombre, ArrayList<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
    }

    public ArrayList<Materia> getMateriasAprobadas(){
        return this.materiasAprobadas;
    }

    public String getNombre(){
        return this.nombre;
    }

}
