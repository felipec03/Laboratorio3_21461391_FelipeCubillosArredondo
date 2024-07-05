package org.example;

import java.util.List;


public class TDATrain {
    int id;
    String trainMaker;
    float speed;
    float stationStayTime;
    List<TDAPassengerCar> pcarList;

    public TDATrain(int id, String trainMaker, float speed, float stationStayTime, List<TDAPassengerCar> pcarList) {
        this.id = id;
        this.trainMaker = trainMaker;
        this.speed = speed;
        this.stationStayTime = stationStayTime;
        this.pcarList = pcarList;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public int getId() {
        return id;
    }

    public float getSpeed() {
        return speed;
    }

    public List<TDAPassengerCar> getPcarList() {
        return pcarList;
    }

    public TDATrain addCar(TDAPassengerCar pcar, int position){
        pcarList.add(position, pcar);
        TDATrain newTrain = new TDATrain(id, trainMaker, speed, stationStayTime, pcarList);
        return newTrain;
    }
    public TDATrain removeCar(int position){
        pcarList.remove(position);
        TDATrain newTrain = new TDATrain(id, trainMaker, speed, stationStayTime, pcarList);
        return newTrain;
    }

    public int fetchCapacity(){
        int output = 0;
        for(TDAPassengerCar curPcar : pcarList){
            output += curPcar.getPassengerCapacity();
        }
        return output;
    }

    public boolean isTrain(){
        TDAPassengerCar firstPcar = (pcarList.get(0));
        TDAPassengerCar lastPcar = (pcarList.get(pcarList.size() - 1));
        return (firstPcar.getType().equals(CarType.t)) && (lastPcar.getType().equals(CarType.t));
    }

    public String traintoString() {
        return "TDATrain{" +
                "id=" + id +
                ", trainMaker='" + trainMaker + '\'' +
                ", speed=" + speed +
                ", stationStayTime=" + stationStayTime +
                ", pcarList=" + pcarList +
                '}';
    }
}

