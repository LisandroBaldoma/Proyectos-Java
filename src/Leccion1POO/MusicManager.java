package Leccion1POO;

import java.util.Arrays;

public class MusicManager {
    public static void main(String[] args) {
        try {
            Artist artist1 = new Artist("John Maus", 43, "Synthpop");
            Producer producer1 = new Producer("Rick Rubin", 60, 30);

            artist1.displayInfo();
            producer1.displayInfo();

            Album album1 = new Album("We Must Become the Pitiless Censors of Ourselves", 2011, artist1);
            Album album2 = new Album("Songs", 1800, artist1);

            album1.displayAlbum();
            album2.displayAlbum();
        } catch (IllegalArgumentException exception) {
            System.out.println("Flujo no deseado: " + Arrays.toString(exception.getStackTrace()));
        }



    }
}