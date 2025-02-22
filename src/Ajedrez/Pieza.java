package Ajedrez;

public abstract class Pieza {
    String name;
    String color;
    Integer pieces;

    public Pieza (String name, String color, Integer pieces){
        this.name = name;
        this.color = color;
        this.pieces = pieces;
    }

    abstract void mostrarMovimientos();
    abstract void mostrarCaptura();

}


