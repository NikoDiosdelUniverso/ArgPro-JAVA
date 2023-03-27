package org.example;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    String nombre;
    List<Materia> correlativas;

    public Materia(String nombre, ArrayList<Materia> correlativas){
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public String getNombre(){
        return this.nombre;
    }

    public boolean puedeCursar(Alumno alumno) {
        for (Materia correlativa : correlativas) {
            if (!alumno.getMateriasAprobadas().contains(correlativa)) {
                return false;
            }
        }
        return true;
    }
}
