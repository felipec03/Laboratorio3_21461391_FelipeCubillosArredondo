package org.example;

public interface InterfazTrain {
    String getTrainMaker();TDATrain addCar(TDAPassengerCar pcar, int position);
    TDATrain removeCar(int position);
    int fetchCapacity();
    boolean isTrain();
    void trainToString();
}
