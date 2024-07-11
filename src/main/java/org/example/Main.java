package org.example;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Pattern;

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

    public static TDALine[] addLine(TDALine[] lines, TDALine newLine) {
        TDALine[] newLines = new TDALine[lines.length + 1];
        System.arraycopy(lines, 0, newLines, 0, lines.length);
        newLines[newLines.length - 1] = newLine;
        return newLines;
    }

    public static TDAPassengerCar[] addPcar(TDAPassengerCar[] pcars, TDAPassengerCar newPcar) {
        TDAPassengerCar[] newPcars = new TDAPassengerCar[pcars.length + 1];
        System.arraycopy(pcars, 0, newPcars, 0, pcars.length);
        newPcars[newPcars.length - 1] = newPcar;
        return newPcars;
    }

    public static TDATrain[] addTrain(TDATrain[] trains, TDATrain newTrain) {
        TDATrain[] newTrains = new TDATrain[trains.length + 1];
        System.arraycopy(trains, 0, newTrains, 0, trains.length);
        newTrains[newTrains.length - 1] = newTrain;
        return newTrains;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Patrón delimitador para la lectura correcta de archivos, uniformemente es un guión
        Pattern delimitador = Pattern.compile(System.lineSeparator() +"|-");

        // ARCHIVO ESTACIONES
        Scanner archivoStations = new Scanner(new File("src/main/texto/stations.txt"));
        archivoStations.useDelimiter(delimitador);
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

        // ARCHIVO SECCIONES
        Scanner archivoSections = new Scanner(new File("src/main/texto/sections.txt"));
        archivoSections.useDelimiter(delimitador);

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

        // ARCHIVO LÍNEAS DE METRO
        Scanner archivoLineas = new Scanner(new File("src/main/texto/lines.txt"));
        archivoLineas.useDelimiter(delimitador);

        TDALine[] lineArray = new TDALine[0];
        while(archivoLineas.hasNext()){
            int newId = archivoLineas.nextInt();
            String newName = archivoLineas.next();
            String newType = archivoLineas.next();
            List<TDASection> newSectionList = new ArrayList<>();

            int firstRange = archivoLineas.nextInt();
            int lastRange = archivoLineas.nextInt();

            TDALine newLine = new TDALine(newId, newName, newType, newSectionList);

            while(lastRange >= firstRange){
                newLine = newLine.lineAddSection(sectionArray[firstRange]);
                firstRange++;
            }

            lineArray = addLine(lineArray, newLine);
        }
        archivoLineas.close();

        // ARCHIVO DE CARROS
        Scanner archivoPcars = new Scanner(new File("src/main/texto/passengercars.txt"));
        archivoPcars.useDelimiter(delimitador);
        TDAPassengerCar[] pcarArray = new TDAPassengerCar[0];

        while(archivoPcars.hasNext()){
            int newId = archivoPcars.nextInt();
            int newPassengerCapacity = archivoPcars.nextInt();
            String newModel = archivoPcars.next();
            String newTrainMaker = archivoPcars.next();
            CarType newCarType = CarType.valueOf(archivoPcars.next());

            TDAPassengerCar newPcar = new TDAPassengerCar(newId, newPassengerCapacity, newModel, newTrainMaker, newCarType);
            pcarArray = addPcar(pcarArray, newPcar);
        }
        archivoPcars.close();

        // ARCHIVO TRAINS
        Scanner archivoTrains = new Scanner(new File("src/main/texto/trains.txt"));
        archivoTrains.useDelimiter(delimitador);
        TDATrain[] trainArray = new TDATrain[0];

        while (archivoTrains.hasNext()){
            int newId = archivoTrains.nextInt();
            String newTrainMaker = archivoTrains.next();
            float newSpeed = archivoTrains.nextFloat();
            float newStationStayTime = archivoTrains.nextFloat();

            List<TDAPassengerCar> newPcarList = new ArrayList<>();

            int firstRange = archivoTrains.nextInt();
            int lastRange = archivoTrains.nextInt();

            TDATrain newTrain = new TDATrain(newId, newTrainMaker, newSpeed, newStationStayTime, newPcarList);

            int position = 0;
            while(lastRange >= firstRange){
                newTrain = newTrain.addCar(pcarArray[firstRange], position);
                firstRange++;
                position++;
            }
            trainArray = addTrain(trainArray, newTrain);
        }
        archivoTrains.close();

        Menu menu = new Menu();
        menu.startMenu();

        System.out.println("PROGRAM HAS FINISHED EXECUTING.");
    }
}
