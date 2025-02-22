package Homeworks;
import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer el radio del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una palabra:");
        String palabra = scanner.next();

        System.out.println("Resultados:");
        System.out.println("palabra ingresada: " + palabra);

        scanner.close();
    }

    public static Integer countLeters(String palabra) {
        return palabra.length();
    }

    public static Integer searchPalabra(String palabra) { return palabra.indexOf("Henry");}

    public static String UperCase(String palabra) {
        return palabra.toUpperCase();
    }

    public static String SubString(String palabra) {
        return palabra.substring(1);
    }

    public static String AgregarPalabra(String palabra) {
        // Agregar 2 o mas palabras en cualquier punto de la frase
        return palabra.substring(1);
    }

    // imprimir los resultados de cada operacion.
}