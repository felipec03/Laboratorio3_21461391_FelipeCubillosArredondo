package org.example;

/**
 * Tipo de estación declarado cómo enumeración
 */
enum StationType{
    r, c, t, m
}

/**
 * La estación es la unidad más básica de la línea, esta tiene sus atributos característicos además de un tipo de estación
 */
public class TDAStation implements InterfazStation {
    private final int id;
    String name;
    StationType type;
    int stopTime;

    /**
     *
     * @param id ID Característico de la estación
     * @param name Nombre de una estación en una línea
     * @param type Tipo de estación, terminal, combinación, regular o mantención.
     * @param stopTime Tiempo de detención de cada estacción.
     */

    public TDAStation(int id, String name, StationType type, int stopTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.stopTime = stopTime;

    }

    public String getName() {
        return name;
    }

    public StationType getType() {
        return type;
    }


    public void stationToString() {
        System.out.println("ID: " + id + " Name: " + name + " Type: " + type + " Stop Time: " + stopTime);
    }
}
