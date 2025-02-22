package Homeworks;
import java.util.Scanner;

public class Circulo {
    // Definición de la constante PI
    public static final double PI = 3.14159;

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer el radio del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el radio del círculo:");
        double radio = scanner.nextDouble();

        double area = calcularArea(radio);
        double circunferencia = calcularCircunferencia(radio);

        System.out.println("Resultados:");
        System.out.println("Área del círculo: " + area);
        System.out.println("Circunferencia del círculo: " + circunferencia);

        scanner.close();
    }

    public static double calcularArea(double radio) {
        return PI * radio * radio;
    }

    public static double calcularCircunferencia(double radio) {
        return 2 * PI * radio;
    }
}