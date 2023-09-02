import java.util.Scanner;

public class Decodificador {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el mensaje cifrado");
        String mensajecifrado = lector.next();
        System.out.println("Cuántas veces se movieron las letras");
        int veces = lector.nextInt();

        String mensajeDescifrado = "";

        for (int i = 0; i < mensajecifrado.length(); i++) {
            char letra = mensajecifrado.charAt(i);
            boolean minuscula = (letra >= 'a' && letra <= 'z');
            boolean mayuscula = (letra >= 'A' && letra <= 'Z');
            if (!(minuscula || mayuscula))
                mensajeDescifrado += letra;
            else {
                int ascii = (int) letra;
                int baseAscii = (int) 'a';
                if (mayuscula)
                    baseAscii = (int) 'A';
                int nuevoAscii = (ascii - baseAscii - veces + 26) % 26 + baseAscii;
                char nuevaLetra = (char) nuevoAscii;
                mensajeDescifrado += nuevaLetra;
            }
        }
        System.out.println("El mensaje descifrado es: " + mensajeDescifrado);
    }
}