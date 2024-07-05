package org.example;

import java.util.List;

public class TDASubway {
    int id;
    String name;
    List<TDADriver> drivers;
    List<TDALine> lines;
    List<TDATrain> trains;

    public TDASubway(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TDASubway addTrain(List<TDATrain> trainList){
        TDASubway subway = new TDASubway(id, name);
        subway.trains = trainList;
        return subway;
    }

    public TDASubway addLine(List<TDALine> lineList){
        TDASubway subway = new TDASubway(id, name);
        subway.lines = lineList;
        return subway;
    }

    public TDASubway addDrivers(List<TDADriver> driverList){
        TDASubway subway = new TDASubway(id, name);
        subway.drivers = driverList;
        return subway;
    }
    @Override
    public String toString() {
        return "TDASubway{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drivers=" + drivers +
                ", lines=" + lines +
                ", trains=" + trains +
                '}';
    }
}
