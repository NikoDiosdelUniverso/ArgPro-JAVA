package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    private static Alumno buscarAlumnoPorNombre(Collection<Alumno> alumnos, String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                return alumno;
            }
        }
        throw new IllegalArgumentException("No se encontró ningún alumno con el nombre " + nombre);
    }

    private static Materia buscarMateriaPorNombre(Collection<Materia> materias, String nombre) {
        for (Materia materia : materias) {
            if (materia.getNombre().equals(nombre)) {
                return materia;
            }
        }
        throw new IllegalArgumentException("No se encontró ninguna materia con el nombre " + nombre);
    }

    public static void main(String[] args) throws IOException {
        // Inicializar materias: crear 3 o 4 materias, con y sin correlativas entre ellas
        ArrayList<Materia> vacio = new ArrayList<>();
        Materia programacion1 = new Materia("Programacion I", vacio);
        Materia programacion2 = new Materia("Programacion II", new ArrayList<>(List.of(programacion1)));
        Materia basesDeDatos = new Materia("Bases de datos I", vacio);
        Collection<Materia> materias = new ArrayList<>(Arrays.asList(programacion1, programacion2, basesDeDatos));

        // Inicializar los alumnos, crear 2 o 3 alumnos, con y sin materias aprobadas.
        // Usar para las materias los MISMOS objetos de la colección de más arriba
        Alumno alumno1 = new Alumno("Jose Rodriguez", new ArrayList<>(List.of(basesDeDatos)));
        Alumno alumno2 = new Alumno("Vanesa Sosa", vacio);
        Alumno alumno3 = new Alumno("Lucia Perez", new ArrayList<>(Arrays.asList(programacion1, programacion2)));
        Collection<Alumno> alumnos = new ArrayList<>(Arrays.asList(alumno1, alumno2, alumno3));

        // Leer el archivo parado por parámetros de args y por cada línea
        // instanciar un objeto Inscripción, pero para llenar las materias y alumnos DEBE usar los objetos que creo más arriba
        // Imprimir la línea, con el resultado si la inscripción está o no ok
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String nombre = parts[0];
            String nombreMateria = parts[1];

            try {
                Alumno alumno = buscarAlumnoPorNombre(alumnos, nombre);
                Materia materia = buscarMateriaPorNombre(materias, nombreMateria);
                Inscripcion inscripcion = new Inscripcion(alumno, materia);
                String resultado = line + " - " + (inscripcion.aprobada() ? "Aprobado" : "Rechazado");
                writer.write(resultado + "\n");
            } catch (IllegalArgumentException e) {
                String resultado = line + " - " + "No se encuentra el nombre o la materia";
                writer.write(resultado + "\n");
            }
        }
        reader.close();
        writer.close();
    }
}