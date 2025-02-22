package Jdbcdao.src;

import Jdbcdao.src.entity.Phone;
import Jdbcdao.src.service.phone.PhoneService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneService phoneService = new PhoneService();
        // Este objeto permite tomar entradas por consola
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de menú
        System.out.println("¡Bienvenido al sistema de gestión de stock de celulares!");
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar un modelo de celular");
            System.out.println("2. Listar todos los modelos");
            // TODO: no olvidar sumar las opciones de los métodos a agregar
            System.out.println("3. Buscar un modelo por ID");
            System.out.println("4. Actualizar stock de un modelo por ID");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del modelo: ");
                    String modelName = scanner.nextLine();
                    System.out.print("Ingrese la cantidad en stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer

                    phoneService.savePhone(modelName, stock);
                    System.out.println("¡Modelo agregado exitosamente!");
                    break;

                case 2:
                    List<Phone> phones = phoneService.findAllPhones();
                    System.out.println("\nModelos en stock:");
                    for (Phone phone : phones) {
                        System.out.println("ID: " + phone.getId() + ", Modelo: " + phone.getModelName() + ", Stock: " + phone.getStock());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del modelo a buscar: ");
                    long searchId = scanner.nextLong();
                    scanner.nextLine();

                    Optional<Phone> phone = phoneService.getPhoneById(searchId);
                    if (phone.isPresent()) {
                        System.out.println("Modelo encontrado: " + phone.get().getModelName() + ", Stock: " + phone.get().getStock());
                    } else {
                        System.out.println("No se encontró un modelo con ese ID.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del modelo a actualizar: ");
                    long updateId = scanner.nextLong();
                    System.out.print("Ingrese el nuevo stock: ");
                    int newStock = scanner.nextInt();
                    scanner.nextLine();

                    boolean updated = phoneService.updateStockById(updateId, newStock);
                    if (updated) {
                        System.out.println("¡Stock actualizado exitosamente!");
                    } else {
                        System.out.println("No se encontró un modelo con ese ID.");
                    }
                    break;

                case 5:
                    System.out.println("¡Gracias por usar el sistema!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}