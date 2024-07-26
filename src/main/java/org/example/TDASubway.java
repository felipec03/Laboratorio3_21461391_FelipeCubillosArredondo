package org.example;

import java.util.List;

/**
 * Clase de mayor presedencia en el proyecto, esta contiene todas las otras clases previemanete definidas
 * Representa un sistema de metro en su totalidad
 */
public class TDASubway {
    private final int id;
    String name;
    List<TDADriver> drivers;
    List<TDALine> lines;
    List<TDATrain> trains;

    /**
     * @param id ID Único e irrepetible del sistema
     * @param name Nombre característico del metro
     */
    public TDASubway(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @param trainList Lista de trenes a añadir
     * @return Metro actualizado
     */
    public TDASubway addTrain(List<TDATrain> trainList){
        TDASubway subway = new TDASubway(id, name);
        subway.drivers = drivers;
        subway.lines = lines;
        subway.trains = trainList;
        return subway;
    }
    /**
     * @param lineList Lista de lineas a añadir
     * @return Metro actualizado
     */
    public TDASubway addLine(List<TDALine> lineList){
        TDASubway subway = new TDASubway(id, name);
        subway.drivers = drivers;
        subway.trains = trains;
        subway.lines = lineList;
        return subway;
    }
    /**
     * @param driverList Lista de conductores a añadir
     * @return Metro actualizado
     */

    public TDASubway addDrivers(List<TDADriver> driverList){
        TDASubway subway = new TDASubway(id, name);
        subway.trains = trains;
        subway.lines = lines;
        subway.drivers = driverList;
        return subway;
    }

    /**
     * Visualización del sistema de metro en su totalidad.
     */
    public void SubwayToString() {
        System.out.println("Linea de metro a trabajar " + name);
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + name );
        for (TDADriver driver : drivers) {
            System.out.println(driver);
        }
        for (TDALine line : lines) {
            System.out.println(line);
        }
        for (TDATrain train : trains) {
            System.out.println(train);
        }
    }
}
