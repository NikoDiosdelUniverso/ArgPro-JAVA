public class Ejercicio2 {

    private static char desplazar(char letra, int x) {
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int index = -1;
        for(int i = 0; i < abecedario.length; i++) {
            if(abecedario[i] == letra) {
                index = i;
            }
        }
        return abecedario[index+x];
    }

    private static String codificar(String unString, int x) {
        String nuevoString = "";
        for (int i = 0; i < unString.length(); i++) {
            if (unString.charAt(i) == ' ') {
                nuevoString += " ";
            }

            else  {
               // nuevoString = nuevoString.replace(unString.charAt(i), desplazar(unString.charAt(i), x));
                nuevoString += desplazar(unString.charAt(i), x);
            }
        }
        return nuevoString;
    }

    private static String decodificar(String stringCodificado, int key) {
        String decodificado = "";
        for (int i = 0; i < stringCodificado.length(); i++) {
            if (stringCodificado.charAt(i) == ' ') {
                decodificado += " ";
            }
            else {
               // decodificado = decodificado.replace(stringCodificado.charAt(i), desplazar(stringCodificado.charAt(i), -key));
                decodificado += desplazar(stringCodificado.charAt(i), -key);
            }
        }
        return decodificado;
    }

    public static void main(String[] args) {
        String mensaje = "mensaje a codificar";
        int clave = 5;
        System.out.println(codificar(mensaje, clave));
        System.out.println(decodificar(codificar(mensaje, clave), clave));
    }

}


