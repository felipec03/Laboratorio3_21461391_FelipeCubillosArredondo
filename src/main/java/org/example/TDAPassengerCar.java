package org.example;

enum CarType
{
    r, t
}
public class TDAPassengerCar {
    int id;
    int passengerCapacity;
    String model;
    String trainMaker;
    CarType type;

    public TDAPassengerCar(int id, int passengerCapacity, String model, String trainMaker, CarType type) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public CarType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TDAPassengerCar{" +
                "id=" + id +
                ", passengerCapacity=" + passengerCapacity +
                ", model='" + model + '\'' +
                ", trainMaker='" + trainMaker + '\'' +
                ", type=" + type +
                '}';
    }
}

