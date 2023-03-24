package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int i = 1;
        do {
            System.out.println("Nombre:");
            String nombre = scn.nextLine();

            System.out.println("Apellido: ");
            String apellido = scn.nextLine();

            int id = i;

            Persona persona = new Persona(id, nombre, apellido);
            System.out.println("Hola, me llamo " + persona.getNombre() + " " + persona.getApellido() + " mi id es " + persona.getId());
            System.out.println("Agregar otra persona?(y/n)");
            i++;
        } while (scn.nextLine().equals("y"));

    }

    //pedir por consola nombre y apellido
    //guardar en una instancia de la clase persona
    //este programa no puede guardar y listar varias personas a la vez
}