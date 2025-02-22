package Interfacescollections;
import java.time.LocalDate;

public interface VideoGame {
    String getTitle();
    String getGenre();
    LocalDate getReleaseDate();
    boolean getWasPlayed();
}
