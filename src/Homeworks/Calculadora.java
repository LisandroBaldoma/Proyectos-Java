package Homeworks;

import java.util.Scanner;

public class Calculadora {
    // Método para sumar
    public double sumar(double a, double b) {
        return a + b;
    }

    // Método para restar
    public double restar(double a, double b) {
        return a - b;
    }

    // Método para multiplicar
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para dividir
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    // Método principal para interactuar con el usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        System.out.println("Bienvenido a la calculadora.");

        try {
            // Solicitar el primer número
            System.out.println("Ingrese el primer número:");
            double num1 = scanner.nextDouble();

            // Solicitar el segundo número
            System.out.println("Ingrese el segundo número:");
            double num2 = scanner.nextDouble();

            // Solicitar la operación
            System.out.println("Ingrese la operación (+, -, *, /):");
            String operacion = scanner.next();

            // Realizar la operación
            double resultado;
            switch (operacion) {
                case "+":
                    resultado = calculadora.sumar(num1, num2);
                    break;
                case "-":
                    resultado = calculadora.restar(num1, num2);
                    break;
                case "*":
                    resultado = calculadora.multiplicar(num1, num2);
                    break;
                case "/":
                    resultado = calculadora.dividir(num1, num2);
                    break;
                default:
                    System.out.println("Operación no válida.");
                    return;
            }

            // Mostrar el resultado
            System.out.println("El resultado de " + num1 + " " + operacion + " " + num2 + " es: " + resultado);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}