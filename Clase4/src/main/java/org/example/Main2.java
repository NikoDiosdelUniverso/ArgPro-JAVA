package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
  //  Haga una main donde por parámetro envíe la ruta de un archivo. Ese archivo debe
 //  contener números. El programa debe escribir por consola la suma de esos números

    private static int sumarNumeros(int[] numeros) {
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        return suma;
    }

    private static int multiplicarNumeros(int[] numeros) {
        int producto = 1;
        for (int numero : numeros) {
            if (numero != 0) {
                producto *= numero;
            }
        }
        return producto;
    }

  public static void main(String[] args) {
      int[] numeros = new int[10];
      try (FileReader fr = new FileReader(args[0]);
           BufferedReader br = new BufferedReader(fr)) {
          String linea;
          int i = 0;
          while ((linea = br.readLine()) != null) {
              String[] numerosComoString = linea.split(" ");
              for (String numeroString : numerosComoString) {
                  int numero = Integer.parseInt(numeroString);
                  numeros[i] = numero;
                  i++;
              }
          }
          System.out.println(Arrays.toString(numeros));
      } catch (IOException e) {
          System.out.println("Error al leer el archivo");
      }

      Scanner scan = new Scanner(System.in);
      System.out.println("multiplicar (m) o sumar (s) los números?:");
      if (scan.nextLine().equals("s")) {
          System.out.println(sumarNumeros(numeros));
      } else if (scan.nextLine().equals("m")) {
          System.out.println(multiplicarNumeros(numeros));
      }

  }
}
