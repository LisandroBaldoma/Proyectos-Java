package Interfacescollections;
import java.time.LocalDate;

public class PCGame implements VideoGame {
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private boolean wasPlayed;

    public PCGame() {
    }

    public PCGame(String title, String genre, LocalDate releaseDate, Boolean wasPlayed) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.wasPlayed = wasPlayed;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getGenre() {
        return this.genre;
    }

    @Override
    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    @Override
    public boolean getWasPlayed() {
        return wasPlayed;
    }
}
