package org.example;

public class TDADriver {
    int id;
    String name;
    String trainMaker;

    public TDADriver(int id, String name, String trainMaker) {
        this.id = id;
        this.name = name;
        this.trainMaker = trainMaker;
    }

    public int getId() {
        return id;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TDADriver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trainMaker='" + trainMaker + '\'' +
                '}';
    }
}
