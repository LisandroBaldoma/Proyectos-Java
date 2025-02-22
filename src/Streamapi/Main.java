package Streamapi;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Series> seriesList = new ArrayList<>();
        seriesList.add(new Series("Breaking Bad", "Netflix", 9.5));
        seriesList.add(new Series("The Sopranos", "Max", 9.2));
        seriesList.add(new Series("The Boys", "Prime Video", 8.7));
        seriesList.add(new Series("Stranger Things", "Netflix", 8.5));
        seriesList.add(new Series("Game of Thrones", "Max", 9.0));

        SeriesEvaluator highRatingEvaluator = series -> series.getRating() > 9.0;

        //TODO: generar nuevo evaluador para la plataforma

        List<String> netflixHighRatedSeries = seriesList.stream()
                .filter(series -> "Netflix".equals(series.getPlatform()))
                .filter(series1 -> highRatingEvaluator.evaluate(series1))
                .map(series -> series.getName())
                .toList();

        // TODO: Usar distinct() para evitar duplicados
        // TODO: generar una nueva lista que solo devuelva 3 resultados (limit)


        System.out.println("High-rated Netflix series:");
        netflixHighRatedSeries.stream().forEach(System.out::println);
    }
}