package Ajedrez;

class Alfil extends Pieza {

    public Alfil(){
        super("Ajedrez.Alfil", "Blanco", 2);
    }

    void mostrarMovimientos(){
        System.out.println("Movimientos del " + name + ":");
        System.out.println("- Se mueve en diagonal");
        System.out.println("- Puede recorrer cualquier numero de casillas");

    }

     void mostrarCaptura(){
         System.out.println("Captura del " + name + ":");
         System.out.println("- Captura de la misma manera en que se mueve");

     }


}
