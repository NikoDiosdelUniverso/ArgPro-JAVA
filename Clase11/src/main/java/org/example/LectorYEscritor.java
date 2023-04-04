package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LectorYEscritor {
private String nombre;
private String ruta;

public LectorYEscritor(String ruta, String nombre){
    this.ruta = ruta;
    this.nombre = nombre;
}
    public void escribirMensaje() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Escriba su mensaje: ");
            String mensaje = scanner.nextLine();
            FileWriter archivo = new FileWriter(this.ruta, true);
            archivo.write(this.nombre + ": " + mensaje + "\n");
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el mensaje.");
        }
    }

    public void leerMensajes() {
        try {
            FileReader archivo = new FileReader(this.ruta);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = lector.readLine();
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer los mensajes.");
        }
    }
}
