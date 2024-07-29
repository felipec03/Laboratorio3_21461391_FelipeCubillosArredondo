package org.example;

/**
 * Corresponde a la unidad de un conductor dentro de un sistema de metro
 */
public class TDADriver {
    private final int id;
    String name;
    String trainMaker;

    /**
     * @param id ID Único e irrepetible del conductor
     * @param name Nombre asociado al conductor
     * @param trainMaker Creador del tren que maneja el conductor
     */
    public TDADriver(int id, String name, String trainMaker) {
        this.id = id;
        this.name = name;
        this.trainMaker = trainMaker;
    }

    /**
     * @return Visualización de un conductor
     */
    @Override
    public String toString() {
        return "TDADriver: " +
                "id: " + id +
                ", name: " + name + '\'' +
                ", trainMaker: '" + trainMaker + '\'';
    }
}
