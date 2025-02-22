package Ajedrez;

class King extends Pieza {

    public King(){
        super("Rey", "Blanco", 1);
    }

    void mostrarMovimientos(){
        System.out.println("Movimientos de la " + name + ":");
        System.out.println("- Una casilla en cualquier direccion");
        System.out.println("- Enroque: Movimiento especial junto con una torre. El rey se mueve 2 casillas hacia una torre, y esta salta al lado opuesto del rey (bajo ciertas condiciones)");
    }

    void mostrarCaptura(){
        System.out.println("Captura del " + name + ":");
        System.out.println("- Captura de la misma manera en que se mueve");

    }




}
