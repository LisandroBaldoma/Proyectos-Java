package Generics;

import Generics.entity.Mouse;
import Generics.service.SupplyService;

public class Main {
    public static void main(String[] args) {
        SupplyService service = new SupplyService();

        //TODO: realizar inicializacion de objetos

        // TODO: Mostrar total de insumos almacenados
        System.out.println("Insumos cargados:");
        //service.getAllSupplies().forEach(System.out::println);

        // Operación con Upper Bound: listar solo dispositivos electrónicos
        System.out.println("\n[Upper Bound] Insumos electrónicos:");
        //service.printElectronicSupplies(service.getAllSupplies());

        // Operación con Lower Bound: agregar un ratón como insumo básico
        System.out.println("\n[Lower Bound] Agregando un ratón...");
        // TODO: corregir uso del método
        //service.addBasicSupply(new Mouse("Mouse óptico", 15.99));
        //service.getAllSupplies().forEach(System.out::println);

        // Operación con Wildcards: mostrar precios totales
        System.out.println("\n[Wildcard] Precio total de insumos:");
        //System.out.printf("Total: %.2f\n", service.calculateESupplyTotalPrice(service.getAllSupplies()));
    }
}