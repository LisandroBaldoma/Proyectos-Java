package Leccion1POO;
public class Artist extends Person {
    //ATRIBUTOS/PROPIEDADES = ESTADO
    private String musicGenre;

    public Artist() {

    }

    //CONSTRUCTOR
    public Artist(String name, Integer age, String musicGenre) {
        super(name, age);
        this.musicGenre = musicGenre;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    //METODOS = ACCIONES / COMUNICACION
    @Override
    public void displayInfo() {
        System.out.println("Artista: " + getName()
                + ", Edad: " + getAge()
                + ", Género musical: " + getMusicGenre());
    }

    @Override
    public void displayInfo(String name) {

    }

    @Override
    public void displayInfo(String name, Integer age) {

    }
}
