package org.example;

enum StationType
{
    r, c, t, m
}

public class TDAStation {
    int id;
    String name;
    StationType type;
    int stopTime;

    public TDAStation(int id, String name, StationType type, int stopTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.stopTime = stopTime;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StationType getType() {
        return type;
    }

    public int getStopTime() {
        return stopTime;
    }



    @Override
    public String toString() {
        return "TDAStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", stopTime=" + stopTime +
                '}';
    }
}
