package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* Escribir un programa de consola que permite chatear de la siguiente forma:
        1. Se tienen que ejecutar varios procesos del mismo programa
        2. Todos al inicializar, tienen que indicar el nombre de la persona
        3. Por la consola tiene que poder ingresar 2 opciones, escribir un mensaje o leer todos los mensajes
        4. cuando elige escribir mensaje, se ingresa el mismo y se escribe en el archivo
        5. otro proceso debe leer todos los mensajes y ver lo que escribio el anterior
        6. El proceso anterior se debe repetir todas las veces que uno quiera
        7. Vale aclarar, que no se leen automáticamente los mensajes, uno debe elegir dicha opción
        */
        String ruta = args[0];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        LectorYEscritor chat = new LectorYEscritor(ruta, nombre);
        boolean seguir = true;
        while (seguir) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Escribir un mensaje");
            System.out.println("2. Leer todos los mensajes");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> chat.escribirMensaje();
                case 2 -> chat.leerMensajes();
                case 3 -> seguir = false;
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
