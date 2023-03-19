package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Nombre:");
        String nombre = scn.nextLine();
        System.out.println("Apellido: ");
        String apellido = scn.nextLine();

        System.out.println("Hola, me llamo "+ nombre + " " + apellido);
    }

    //pedir por consola nombre y apellido
    //guardar en una instancia de la clase persona
}