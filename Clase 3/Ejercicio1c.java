public class Ejercicio1c {
    //dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado
    private static int sumar(int[] numeros, int x) {
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]> x) {
                suma += numeros[i];
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] listaNumeros = {1, 2, 3, 4, 5, 6};
        int a = 4;
        System.out.print(sumar(listaNumeros, a));
    }
}
