public class Ejercicio2 {
    public static void main(String[] args) {

        float ingresos = 299000;
        int vehiculos = 2;
        int inmuebles = 1;
        boolean embarcacion = false;
        boolean aeronave = false;

        if ( (ingresos < 489083) &&
                ( vehiculos < 3) &&
                (inmuebles < 3) &&
                (embarcacion == false) &&
                (aeronave == false) ) {
            System.out.println("No pertenece a la categoria de ingresos altos");
        } else  {
            System.out.println("Pertenece a la categoria de Ingresos altos");
        }
    }
}
