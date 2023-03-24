package org.example;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //toma tres numeros y los ordena en orden ascendente
    private static int[] ordenarAsc(int x, int y, int z) {
        int[] ordenados = {x, y, z};
        Arrays.sort(ordenados);
        return ordenados;
    }

    //toma un array de numeros e invierte el orden
    private static int[] ordenarDesc(int[] ordenados) {
        int[] ordenInvertido = {0,0,0};
        for (int i = 0; i < ordenados.length ; i++) {
            ordenInvertido[i] = ordenados[ordenados.length - i - 1];
        }
        return ordenInvertido;
    }

    public static void main(String[] args) {
        char orden;
        int a;
        int b;
        int c;

        //si el programa no recibe argumentos, los pide por consola
        if (args.length == 0) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Ingrese 3 numeros separados por un espacio");

            String[] numerosComoString = scn.nextLine().split(" ");

            int[] numeros = new int[numerosComoString.length];

            for (int i = 0; i < numerosComoString.length; i++) {
                numeros[i] = Integer.parseInt(numerosComoString[i]);
            }
            a = numeros[0];
            b = numeros[1];
            c = numeros[2];

            System.out.println("Ordenar en orden ascendente (a)/ ordenar en orden descendente (d):");
            orden = scn.nextLine().charAt(0);
        } else {
           //el tercer argumento determina si los numeros se ordenaran de forma ascendente o descendente
           orden = args[3].charAt(0);
           //los primeros tres argumentos son los numeros a ordenar
           a = Integer.parseInt(args[0]);
           b = Integer.parseInt(args[1]);
           c = Integer.parseInt(args[2]);
        }

        if (orden == 'a') {
            System.out.print(Arrays.toString(ordenarAsc(a, b, c)));
        }
        else if (orden == 'd'){
            System.out.print(Arrays.toString(ordenarDesc(ordenarAsc(a,b,c))));
        }

    }


}