package Generics.entity;

public class ElectronicSupply extends Item {
    private String name;
    private double price;

    public ElectronicSupply(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Insumo: %s | Precio: %.2f", name, price);
    }
}
