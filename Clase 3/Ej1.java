public class Ej1 {
    
    private static int contarCaracteres(String unString, char unaLetra) {
        int contador = 0;
        for (int i = 0; i < unString.length(); i++)
        {
            if (unString.charAt(i) == unaLetra) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        System.out.print(contarCaracteres("aaaaaaaaaa", 'a'));
    }

}

