package Ajedrez;

class Peon extends Pieza {

    public Peon(){
        super("Ajedrez.Peon", "Blanco", 8);
    }

    void mostrarMovimientos(){
        System.out.println("Movimientos del " + name + ":");
        System.out.println("- Avanza 1 casilla hacia adelante");
        System.out.println("- En su primer movimiento, puede avanzar 2 casillas hacia adelante");

    }

     void mostrarCaptura(){
         System.out.println("Captura del " + name + ":");
         System.out.println("- Captura en diagonal hacia adelante");

     }


}
