package Streamapi;

@FunctionalInterface
public interface SeriesEvaluator {
    //TODO: crear otra interfaz funcional que reciba 2 parametros y devuelva un booleano
    boolean evaluate(Series series);
}
