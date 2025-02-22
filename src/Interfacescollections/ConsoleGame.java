package Interfacescollections;
import java.time.LocalDate;

public class ConsoleGame implements VideoGame{
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private boolean wasPlayed;

    public ConsoleGame() {
    }

    public ConsoleGame(String title, String genre, LocalDate releaseDate, Boolean wasPlayed) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.wasPlayed = wasPlayed;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean getWasPlayed() {
        return wasPlayed;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
