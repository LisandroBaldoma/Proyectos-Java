package Generics.service;

import Generics.entity.Mouse;
import Generics.entity.ElectronicSupply;

import java.util.ArrayList;
import java.util.List;

public class SupplyService {
    // TODO: qué puedo hacer con la definicion de esta lista,
    //  + en relacion a la inicialización de datos sugerida tambien en el main?
    List<ElectronicSupply> supplies = new ArrayList<>();

    //Lower bound
    public void addBasicSupply(List<? super Mouse> list, Mouse mouse) {
        list.add(mouse);
    }

    //Upper Bound
    public void printElectronicSupplies(List<? extends ElectronicSupply> list) {
        list.stream().forEach(System.out::println);
    }

    public double calculateESupplyTotalPrice(List<?> list) {
        //TODO: implementar un bounded generic al parámetro
        return list.stream()
                .filter(item -> item instanceof ElectronicSupply)
                .mapToDouble(item -> ((ElectronicSupply) item).getPrice())
                .sum();

    }

}
