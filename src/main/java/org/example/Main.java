package org.example;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.sql.SQLOutput;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static TDAStation[] addStations(TDAStation[] stations, TDAStation newStation) {
        TDAStation[] newStations = new TDAStation[stations.length + 1];
        System.arraycopy(stations, 0, newStations, 0, stations.length);
        newStations[newStations.length - 1] = newStation;
        return newStations;
    }

    public static TDASection[] addSections(TDASection[] sections, TDASection newSection) {
        TDASection[] newSections = new TDASection[sections.length + 1];
        System.arraycopy(sections, 0, newSections, 0, sections.length);
        newSections[newSections.length - 1] = newSection;
        return newSections;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner archivoStations = new Scanner(new File("src/main/texto/stations.txt"));
        archivoStations.useDelimiter("-|\n");
        TDAStation[] stationArray = new TDAStation[0];

        while(archivoStations.hasNext()){
            int newId = archivoStations.nextInt();

            String newName = archivoStations.next();

            StationType newType = StationType.valueOf(archivoStations.next());

            int newStopTime = archivoStations.nextInt();

            TDAStation newStation = new TDAStation(newId, newName, newType, newStopTime);
            stationArray = addStations(stationArray, newStation);
        }
        archivoStations.close();

        System.out.println("PRINTING STATIONS:");
        for(TDAStation station : stationArray){
            System.out.println(station);
        }
        System.out.println("STATIONS PRINTED SUCCESFULY!");

        Scanner archivoSections = new Scanner(new File("src/main/texto/sections.txt"));
        archivoSections.useDelimiter("-|\n");

        TDASection[] sectionArray = new TDASection[0];
        while(archivoSections.hasNext()){
            TDAStation newPoint1 = stationArray[archivoSections.nextInt()];
            TDAStation newPoint2 = stationArray[archivoSections.nextInt()];
            float newDistance = archivoSections.nextFloat();
            float newCost = archivoSections.nextFloat();

            TDASection newSection = new TDASection(newPoint1, newPoint2, newDistance, newCost);
            sectionArray = addSections(sectionArray, newSection);
        }
        archivoSections.close();

        System.out.println("PRINTING SECTIONS:");
        for (TDASection section : sectionArray){
            System.out.println(section);
        }
        System.out.println("SECTIONS PRINTED SUCCESFULY!");

        Scanner archivoLineas = new Scanner(new File("src/main/texto/lineas.txt"));
        archivoLineas.useDelimiter("-|\n");

        TDALine[] lineArray = new TDALine[0];
        while(archivoLineas.hasNext()){
            int newId = archivoLineas.nextInt();
            String newName = archivoLineas.next();
            String newType = archivoLineas.next();
            while(archivoLineas.hasNextInt() ){
                int sectionIndex = archivoLineas.nextInt();
                TDASection newSection = sectionArray[sectionIndex];
            }
        }

        System.out.println("PROGRAM HAS FINISHED EXECUTING.");
    }
}
