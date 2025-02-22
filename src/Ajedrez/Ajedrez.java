package Ajedrez;

public class Ajedrez {
    public static void main(String[] args) {

        Peon peon = new Peon();
        peon.mostrarMovimientos();
        peon.mostrarCaptura();

        Tower tower = new Tower();
        tower.mostrarMovimientos();
        tower.mostrarCaptura();

        Alfil alfil = new Alfil();
        alfil.mostrarMovimientos();
        alfil.mostrarCaptura();

        Horse horse = new Horse();
        horse.mostrarMovimientos();
        horse.mostrarCaptura();
/*
        Ajedrez.Pieza[] piezas = {
                new Ajedrez.Peon(),
                new Ajedrez.Tower(),
                new Ajedrez.Alfil(),
                new Ajedrez.Horse(),
                new Ajedrez.Dama(),
                new Ajedrez.King()
        };

        for (Ajedrez.Pieza pieza : piezas){
            pieza.mostrarMovimientos();
            pieza.mostrarCaptura();
        }

 */

    }
}
