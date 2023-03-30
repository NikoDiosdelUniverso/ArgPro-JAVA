package org.example;
import org.example.Excepciones.MismaMateriaException;
import org.example.Excepciones.NoSeEncuentraException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Inscripcion {
    Alumno alumno;
    Materia materia;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }

    public boolean aprobada() {
        try {
            return this.materia.puedeCursar(this.alumno);
        } catch (MismaMateriaException e){
           e.printStackTrace();
        }
        return false;
    }

    public void imprimirResultados(Collection<Inscripcion> listaDeInscripciones, String ruta) throws IOException {
        FileWriter writer = new FileWriter(ruta);

        for (Inscripcion inscripcion : listaDeInscripciones) {
            String line = inscripcion.alumno.getNombre() + " - " + inscripcion.materia.getNombre();
            try {
                String resultado = line + " - " + (inscripcion.aprobada() ? "Aprobado" : "Rechazado");
                writer.write(resultado + "\n");
            } catch (IllegalArgumentException e) {
                String resultado = line + " - " + "No se encuentra el nombre o la materia";
                writer.write(resultado + "\n");
            }
        }
        writer.close();
    }
}
