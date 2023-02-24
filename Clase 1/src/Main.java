public class Main {
    public static void main(String[] args) {

        int inicio = 10;
        int fin = 20;
        boolean par = false;

    /*    while(inicio <= fin){
            if (par) {
                if (inicio%2==0) {
                    System.out.println(inicio);
                }
            } else {
                if (inicio%2!=0) {
                    System.out.println(inicio);
                }
            }
            inicio=inicio+1;
        }
    } */
        for (int i = fin; i >= inicio; i--) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        }
    }