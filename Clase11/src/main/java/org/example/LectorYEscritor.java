package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LectorYEscritor {

    public static void escribirMensaje(String nombre) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Escriba su mensaje: ");
            String mensaje = scanner.nextLine();
            FileWriter archivo = new FileWriter("chat.txt", true);
            archivo.write(nombre + ": " + mensaje + "\n");
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el mensaje.");
        }
    }

    public static void leerMensajes() {
        try {
            FileReader archivo = new FileReader("chat.txt");
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
