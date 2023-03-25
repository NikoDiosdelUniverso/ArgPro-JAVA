package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main3 {

    private static char desplazar(char letra, int x) {
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int index = -1;
        for(int i = 0; i < abecedario.length; i++) {
            if(abecedario[i] == letra) {
                index = i;
            }
        }
        return abecedario[index+x];
    }

    private static String codificar(String unString, int x) {
        String nuevoString = "";
        for (int i = 0; i < unString.length(); i++) {
            if (unString.charAt(i) == ' ') {
                nuevoString += " ";
            }

            else  {
                nuevoString += desplazar(unString.charAt(i), x);
            }
        }
        return nuevoString;
    }

    private static String decodificar(String stringCodificado, int key) {
        String decodificado = "";
        for (int i = 0; i < stringCodificado.length(); i++) {
            if (stringCodificado.charAt(i) == ' ') {
                decodificado += " ";
            }
            else {
                decodificado += desplazar(stringCodificado.charAt(i), -key);
            }
        }
        return decodificado;
    }

    private static String getMensaje(String rutaEntrada) {
        String mensaje = "";
        try {
            mensaje = Files.readString(Paths.get(rutaEntrada));
         //   System.out.println(mensaje);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return mensaje;
    }

    private static void escribirResultado(String ruta, String mensaje) {
        try {
            FileWriter writer = new FileWriter(ruta);
            writer.write(mensaje);
            writer.close();
            System.out.println("Se ha escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //el primer argumento debe indicar si es una codificacion (true) o decodificacion (false)
        boolean codificar = Boolean.parseBoolean(args[0]);
        //el segundo argumento debe indicar la clave(valor del desplazamiento)
        int clave = Integer.parseInt(args[1]);
        //el tercer argumento debe ser la ruta del archivo de entrada (texto a codificar o decodificar)
        String rutaEntrada = args[2];
        //el cuarto argumento debe ser la ruta del archivo de salida (donde estaran los resultados)
        String rutaSalida = args[3];
        String mensaje = getMensaje(rutaEntrada);

        if (codificar) {
            escribirResultado(rutaSalida, codificar(mensaje, clave));
         //   System.out.println(codificar(mensaje, clave));
        } else {
            escribirResultado(rutaSalida, decodificar(mensaje, clave));
          //  System.out.println(decodificar(codificar(mensaje, clave), clave));
        }


    }

}
