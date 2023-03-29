package org.example.Utilidades;

import org.example.Alumno;
import org.example.Inscripcion;
import org.example.Materia;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LectorDeArchivos {

    private String rutaAlumnos;
    private String rutaMaterias;
    private String rutaCorrelativas;
    private String rutaAprobadas;
    private String rutaIncripciones;

    public LectorDeArchivos(String rutaAlumnos, String rutaMaterias, String rutaCorrelativas, String rutaAprobadas, String rutaIncripciones){
        this.rutaAlumnos = rutaAlumnos;
        this.rutaMaterias = rutaMaterias;
        this.rutaAprobadas = rutaAprobadas;
        this.rutaCorrelativas = rutaCorrelativas;
        this.rutaIncripciones = rutaIncripciones;
    }

    public Collection<Alumno> getAlumnos() throws IOException {
        List<Alumno> alumnos = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.rutaAlumnos));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String nombre = parts[0];

            try {
                Alumno alumno = new Alumno(nombre);
                alumnos.add(alumno);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        reader.close();
        return alumnos;
    }

    public Alumno buscarAlumnoPorNombre(Collection<Alumno> alumnos, String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                return alumno;
            }
        }
        throw new IllegalArgumentException("No se encontró ningún alumno con el nombre " + nombre);
    }

    public Collection<Materia> getMaterias() throws IOException {
        List<Materia> materias = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.rutaMaterias));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String nombre = parts[0];

            try {
                Materia materia = new Materia(nombre);
                materias.add(materia);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        reader.close();
        return materias;
    }

    public Materia buscarMateriaPorNombre(Collection<Materia> materias, String nombre) {
        for (Materia materia : materias) {
            if (materia.getNombre().equals(nombre)) {
                return materia;
            }
        }
        throw new IllegalArgumentException("No se encontró ninguna materia con el nombre " + nombre);
    }

    public void getAprobadas() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.rutaMaterias));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String nombreAlumno = parts[0];
            String nombreMateria = parts[1];
            try {
                Alumno alumno = buscarAlumnoPorNombre(getAlumnos(), nombreAlumno);
                Materia materia = buscarMateriaPorNombre(getMaterias(), nombreMateria);
                alumno.setMateriasAprobadas(materia);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        reader.close();
    }
    public void getCorrelativas() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.rutaMaterias));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String nombreMateria = parts[0];
            String nombreCorrelativa = parts[1];

            try {
                Materia materia = buscarMateriaPorNombre(getMaterias(), nombreMateria);
                Materia correlativa = buscarMateriaPorNombre(getMaterias(), nombreCorrelativa);
                materia.setCorrelativas(correlativa);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        reader.close();
    }

    public Collection<Inscripcion> getInscripciones() throws IOException {
        List<Inscripcion> inscripciones = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.rutaMaterias));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String nombre = parts[0];
            String nombreMateria = parts[1];

            try {
                Alumno alumno = buscarAlumnoPorNombre(getAlumnos(), nombre);
                Materia materia = buscarMateriaPorNombre(getMaterias(), nombreMateria);
                Inscripcion inscripcion = new Inscripcion(alumno, materia);
                inscripciones.add(inscripcion);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        reader.close();
        return inscripciones;
    }
}
