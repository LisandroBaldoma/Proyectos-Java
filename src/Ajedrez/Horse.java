package Ajedrez;

class Horse extends Pieza {

    public Horse(){
        super("Caballo", "Blanco", 2);
    }

    void mostrarMovimientos(){
        System.out.println("Movimientos de la " + name + ":");
        System.out.println("- Se mueve en forma de 'L': dos casillas en una direccion (horizontal o vertical) y una mas perpendicular a esta");
        System.out.println("- Puede saltar entre otras piezas");

    }

     void mostrarCaptura(){
         System.out.println("Captura del " + name + ":");
         System.out.println("- Captura de la misma manera en que se mueve");

     }


}
