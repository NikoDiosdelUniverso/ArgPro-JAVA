import java.util.Arrays;

public class Ejercicio1b {

     private static int[] ordenAscendente(int x, int y, int z) {
             int[] numeros = {x, y, z};
         if (x <= y) {
                 if (x <= z){
                     numeros[1] = z;
                     numeros[2] = y;
                 }
                 else if (x > z){
                     numeros[0] = z;
                     numeros[1] = x;
                     numeros[2] = y;
                 }
             }
             if (x > y) {
                 if (y > z) {
                     numeros[0] = z;
                     numeros[2] = x;
                 }
                 else if (x < z){
                     numeros[0] = y;
                     numeros[1] = x;
                 }
                 else if (x > z){
                     numeros[0] = y;
                     numeros[1] = z;
                     numeros[2] = x;
                 }
             }
         return numeros;
     }
    
     public static void main(String[] args) {
         boolean ordenAscendente = false;
         int a = 5;
         int b = 25;
         int c = 10;
         ordenAscendente(a, b, c);
         if (ordenAscendente) {
             System.out.print(Arrays.toString(ordenAscendente(a, b, c)));
         }
         else {
             int[] nuevoarray = ordenAscendente(a, b, c);
             nuevoarray[0] = ordenAscendente(a, b, c)[2];
             nuevoarray[2] = ordenAscendente(a, b, c)[0];
             System.out.print(Arrays.toString(nuevoarray));
         }

        }
}


