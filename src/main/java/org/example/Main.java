package org.example;

import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static TDAStation[] addStations(TDAStation[] stations, TDAStation newStation) {
        TDAStation[] newStations = new TDAStation[stations.length + 1];
        System.arraycopy(stations, 0, newStations, 0, stations.length);
        newStations[newStations.length - 1] = newStation;
        return newStations;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner archivoStations = new Scanner(new File("src/main/texto/stations.txt"));

        TDAStation[] stationArray = new TDAStation[0];

        while(archivoStations.hasNext()){
            int newId = archivoStations.nextInt();
            System.out.println(newId);
            //String newName = archivoStations.next();
            //StationType newType = StationType.valueOf(archivoStations.next());
            //int newStopTime = archivoStations.nextInt();

            //TDAStation newStation = new TDAStation(newId, newName, newType, newStopTime);
            //stationArray = addStations(stationArray, newStation);
        }

        System.out.println("HELLO");
    }
}
