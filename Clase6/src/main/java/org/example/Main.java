package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double result;
        boolean quit = false;

        System.out.println("Bienvenido a la calculadora");
        System.out.println("Por favor seleccione una operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");

        while (!quit) {
            System.out.print("Ingrese la opción deseada: ");
            int choice = scanner.nextInt();
            Calculadora calculadora = new Calculadora();
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    result = calculadora.sumar(num1, num2);
                    System.out.println("El resultado es: " + result);
                    break;

                case 2:
                    result = calculadora.restar(num1, num2);
                    System.out.println("El resultado es: " + result);
                    break;

                case 3:
                    result = calculadora.multiplicar(num1, num2);
                    System.out.println("El resultado es: " + result);
                    break;

                case 4:
                    if (num2 == 0) {
                        System.out.println("No se puede dividir por cero");
                    } else {
                        result = calculadora.multiplicar(num1, num2);
                        System.out.println("El resultado es: " + result);
                    }
                    break;

                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo");
                    break;
            }
        }
        scanner.close();
    }
}