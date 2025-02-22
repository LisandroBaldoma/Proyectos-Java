package Interfacescollections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VideoGameCollection {
    List<VideoGame> gameList = new ArrayList<>();
    Set<String> uniqueGenres = new HashSet<>();
    Map<String, LocalDate> lastPlayed = new HashMap<>();

    // Agregar un juego a la coleccion y a los generos
    public void addGame(VideoGame game) {
        gameList.add(game);
        uniqueGenres.add(game.getGenre());
        lastPlayed.put(game.getTitle(), game.getReleaseDate());
    }

    // Marcar un juego como jugado
    public void markAsPlayed(String title) {
        lastPlayed.put(title, LocalDate.now());
    }

    // mostrar los ultimos jugados
    public void showLastPlayed() {
        System.out.println("Últimas partidas: ");
        for (Map.Entry<String, LocalDate> entry : lastPlayed.entrySet()) {
            System.out.printf("Juego: %s, Última partida: %s%n",
                    entry.getKey(), entry.getValue());
           // System.out.print("nombre " + entry.getKey() + "ultima partida " + entry.getValue());
        }
    }

    //obtener los generos
    public void showUniqueGenres() {
        System.out.println("Géneros únicos: ");
        for (String genre : uniqueGenres) {
            System.out.println(genre);
        }
    }

    public void listAllGames() {
        System.out.println("Listado de juegos");
        for (VideoGame game : gameList) {
            if (game instanceof ConsoleGame) {
                System.out.println("Juego de consola: " + game.getTitle());
            } else if (game instanceof  PCGame) {
                System.out.println("Juego de PC: " + game.getTitle());
            }
            //System.out.println(game.getTitle());
        }
    }
// TODO:
    public void listIsGamaing(){
        System.out.println("Estos son los juegos que se jugaron");
        for (VideoGame game : gameList) {
            if(game.getWasPlayed()) {
                System.out.println(game.getTitle());
            }
        }
    }


}
