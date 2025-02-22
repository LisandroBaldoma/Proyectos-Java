package Ajedrez;

class Tower extends Pieza {

    public Tower(){
        super("Torre", "Blanco", 2);
    }

    void mostrarMovimientos(){
        System.out.println("Movimientos de la " + name + ":");
        System.out.println("- Se mueve en linea recta horizontal o vertical");
        System.out.println("- Puede recorrer cualquier numero de casillas");

    }

     void mostrarCaptura(){
         System.out.println("Captura del " + name + ":");
         System.out.println("- Captura de la misma manera en que se mueve");

     }


}
