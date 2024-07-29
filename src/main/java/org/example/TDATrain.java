package org.example;

import java.util.List;


/**
 * Corresponde a la representación de un tren dentro de un sistema de metro
 * Este contiene, además de atributos identificadores, una lista de carros que conforman un convoy.
 */
public class TDATrain {
    private final int id;
    String trainMaker;
    float speed;
    float stationStayTime;
    List<TDAPassengerCar> pcarList;

    /**
     * @param id ID Característico e irrepetible de un tren
     * @param trainMaker Creador del tren
     * @param speed Velocidad máxima de un tren
     * @param stationStayTime Tiempo que un tren espera en una estación
     * @param pcarList Lista que contiene todos los carros que contiene la instancia del tren
     */
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

    /**
     * @param pcar Carro a añadir
     * @param position Posición donde se añada el carro
     * @return Nueva instancia de tren con el carro añadido
     */
    public TDATrain addCar(TDAPassengerCar pcar, int position){
        pcarList.add(position, pcar);
        return new TDATrain(id, trainMaker, speed, stationStayTime, pcarList);
    }

    /**
     * @param position Posición que se desea eliminar el carro de un tren
     * @return Instancia de tren con el carro eliminado en posición deseada
     */
    public TDATrain removeCar(int position){
        pcarList.remove(position);
        return new TDATrain(id, trainMaker, speed, stationStayTime, pcarList);
    }

    /**
     * @return Cantidad total de un tren de sostener personas
     */
    public int fetchCapacity(){
        int output = 0;
        for(TDAPassengerCar curPcar : pcarList){
            output += curPcar.getPassengerCapacity();
        }
        return output;
    }

    /**
     * @return true si el tren cumple con todos los requerimientos dados: Primero y último carro terminal, etc... false en cualquier otro caso
     */
    public boolean isTrain(){
        TDAPassengerCar firstPcar = (pcarList.get(0));
        TDAPassengerCar lastPcar = (pcarList.get(pcarList.size() - 1));
        return (firstPcar.getType().equals(CarType.t)) && (lastPcar.getType().equals(CarType.t));
    }

    /**
     *  Visualización del tren instanciado
     */
    public void trainToString() {
        System.out.println("ID: "+ id);
        System.out.println("Train Maker: " + trainMaker);
        System.out.println("Speed: " + speed);
        System.out.println("Station Stay Time: " + stationStayTime);
        for (TDAPassengerCar car : pcarList) {
            System.out.println(car);
        }
    }
}

