package Ajedrez;

class Dama extends Pieza {

    public Dama(){
        super("Ajedrez.Dama", "Blanco", 1);
    }

    void mostrarMovimientos(){
        System.out.println("Movimientos de la " + name + ":");
        System.out.println("- Se mueve cualquier numero de casillas en linea recta (horizonal, veritcal o diagonal)");
            }

    void mostrarCaptura(){
        System.out.println("Captura del " + name + ":");
        System.out.println("- Captura de la misma manera en que se mueve");

    }


}
