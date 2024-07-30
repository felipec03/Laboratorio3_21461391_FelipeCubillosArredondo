package org.example;

/**
 * Declara el tipo de carro, osease, si es regular o terminal (reside en los extremos)
 */
enum CarType {
    r, t
}

/**
 * Unidad básica del tren, esta representa un carro singular en un convoy, con sus atributos característicos
 */
public class TDAPassengerCar implements InterfazPassengerCar{
    private final int id;
    int passengerCapacity;
    String model;
    String trainMaker;
    CarType type;

    /**
     * @param id ID Característico e irrepetible del carro
     * @param passengerCapacity Capacidad que tiene un carro de sostener una cantidad de personas
     * @param model Modelo del carro
     * @param trainMaker Creador del carro
     * @param type Tipo de carro en cuestión, regular o terminal.
     */
    public TDAPassengerCar(int id, int passengerCapacity, String model, String trainMaker, CarType type) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
        this.type = type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
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

