package Leccion1POO;

public class Album {
    private static final int MIN_YEAR = 1900;

    private String title;
    private Integer year;
    private Artist artist;

    public Album(String title, Integer year, Artist artist) throws IllegalArgumentException {
        if (year < MIN_YEAR) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.year = year;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void displayAlbum() {
        System.out.println("Album: " + this.title
                + ", Year: " + this.year
                + ", Artist: " + artist.getName());
    }
}
