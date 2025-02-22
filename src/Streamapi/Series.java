package Streamapi;
public class Series {
    private String name;
    private String platform;
    private double rating;
    //TODO: sumar 2 propiedades más para realizar otras operaciones

    public Series(String name, String platform, double rating) {
        this.name = name;
        this.platform = platform;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + this.name + '\'' +
                ", platform='" + this.platform + '\'' +
                ", rating=" + this.rating +
                '}';
    }
}
