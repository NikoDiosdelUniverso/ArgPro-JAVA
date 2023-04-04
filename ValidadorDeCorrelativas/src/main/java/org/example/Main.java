package org.example;

import org.example.Excepciones.MismaMateriaException;
import org.example.Excepciones.NoSeEncuentraException;
import org.example.Utilidades.LectorDeArchivos;

import java.io.IOException;
import java.util.Collection;


public class Main {

    public static void main(String[] args) throws IOException, NoSeEncuentraException {

        LectorDeArchivos lector = new LectorDeArchivos(args[0], args[1], args[2], args[3], args[4]);
        Collection<Materia> listaDeMaterias = lector.getMaterias();
        Collection<Alumno> listaDeAlumnos = lector.getAlumnos();

        lector.getCorrelativas(listaDeMaterias);
        lector.getAprobadas(listaDeAlumnos, listaDeMaterias);
        try {
            for (Inscripcion inscripcion : lector.getInscripciones(listaDeAlumnos, listaDeMaterias)) {
                inscripcion.imprimirResultados(lector.getInscripciones(listaDeAlumnos, listaDeMaterias), args[5]);
            }
        } catch (MismaMateriaException e) {
            e.printStackTrace();
        }


        for (Materia materia : listaDeMaterias) {
            System.out.println(materia.getNombre());
            System.out.println("Mis correlativas son: ");
            for (Materia c : materia.getCorrelativas()) {
                System.out.println(c.getNombre());
            }
            System.out.println("-----------------------");
        }

        for (Alumno alumno : listaDeAlumnos) {
            System.out.println(alumno.getNombre());
            System.out.println("Mis materias aprobadas son: ");
            for(Materia a : alumno.getMateriasAprobadas()) {
                System.out.println(a.getNombre());
            }
            System.out.println("-----------------------");
        }




    }
}