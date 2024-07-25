package org.example;

import java.util.Scanner;

/**
 * El menú es una clase que tiene por fin ordenar el código, esta representa por medio del método startMenu el inicio de este.
 */
public class Menu {
    /**
     * Se utiliza constructor para llamar al menu en main
     */
    public Menu() {
    }

    /**
     * Muestra por consola el menú para que el usuario vea las opciones disponibles dentro del sistema
     */
    protected void mostrarOpciones(){
        System.out.println("Bienvenido al sistema de metro!");
        System.out.println("------ Opciones para las líneas ------");
        System.out.println("1. LineLength");
        System.out.println("2. lineSectionLength");
        System.out.println("3. lineCost");
        System.out.println("4. lineSectionCost");
        System.out.println("5. isLine");
        System.out.println("------ Opciones para los trenes ------");
        System.out.println("6. trainAddCar");
        System.out.println("7. trainRemoveCar");
        System.out.println("8. isTrain");
        System.out.println("9. fetchCapacity");
        System.out.println("------ Opciones para los subways ------");
        System.out.println("10. whereIsTrain");
        System.out.println("11. trainPath");
        System.out.println("12. Retornar al menú de inicio...");
    }

    /**
     * @param lineArray lectura de líneas en main
     * @param pcarArray lectura de carros en main
     * @param trainArray lectura de trenes en main
     * Inicializa el menú con las opciones dentro de un switch case
     */
    protected void startMenu(TDALine[] lineArray, TDAPassengerCar[] pcarArray, TDATrain[] trainArray){
        int opcion = 0;
        mostrarOpciones();
        while(opcion != 12){
            Scanner input = new Scanner(System.in);
            System.out.println("Introduzca una opción: ");

            opcion = Integer.parseInt(input.nextLine());

            switch(opcion){
                case 1:
                    System.out.println("Elegido lineLength!");
                    Scanner id = new Scanner(System.in);
                    System.out.println("Introduzca el ID de la linea a operar: ");
                    int lineID = Integer.parseInt(input.nextLine());
                    float output = lineArray[lineID].lineLength();
                    System.out.println("Largo de " + lineArray[lineID].getName() + " es: " + output);
                    break;
                case 2:
                    System.out.println("Elegido lineSectionLength!");

                    Scanner idB = new Scanner(System.in);
                    System.out.println("Introduzca el ID de la linea a operar: ");
                    int lineIDB = Integer.parseInt(input.nextLine());

                    Scanner firstIn = new Scanner(System.in);
                    System.out.println("Introduzca el nombre de la primera estación: ");
                    String firstStation = firstIn.nextLine();

                    Scanner lastIn = new Scanner(System.in);
                    System.out.println("Introduzca el nombre de la segunda estación: ");
                    String lastStation = lastIn.nextLine();

                    float outputLSL = lineArray[lineIDB].lineSectionLength(firstStation, lastStation);
                    System.out.println("Largo desde estación " + firstStation + " hasta estación " + lastStation + " en " + lineArray[lineIDB].getName() + " es: " + outputLSL);

                    break;
                case 3:
                    System.out.println("Elegido lineCost!");

                    Scanner idC = new Scanner(System.in);
                    System.out.println("Introduzca el ID de la linea a operar: ");
                    int lineIDC = Integer.parseInt(input.nextLine());
                    float outputC = lineArray[lineIDC].lineCost();
                    System.out.println("Costo total de " + lineArray[lineIDC].getName() + " es: " + outputC);

                    break;
                case 4:
                    System.out.println("Elegido lineSectionCost!");

                    Scanner idD = new Scanner(System.in);
                    System.out.println("Introduzca el ID de la linea a operar: ");
                    int lineIDD = Integer.parseInt(input.nextLine());

                    Scanner firstInD = new Scanner(System.in);
                    System.out.println("Introduzca el nombre de la primera estación: ");
                    String firstStationD = firstInD.nextLine();

                    Scanner lastInD = new Scanner(System.in);
                    System.out.println("Introduzca el nombre de la segunda estación: ");
                    String lastStationD = lastInD.nextLine();

                    float outputLSC = lineArray[lineIDD].lineSectionCost(firstStationD, lastStationD);
                    System.out.println("Costo desde estación " + firstStationD + " hasta estación " + lastStationD + " en " + lineArray[lineIDD].getName() + " es: " + outputLSC);

                    break;
                case 5:
                    System.out.println("Elegido isLine!");

                    Scanner idE = new Scanner(System.in);
                    System.out.println("Introduzca el ID de la linea a verificar: ");
                    int lineIDE= Integer.parseInt(input.nextLine());

                    if(lineArray[lineIDE].isLine(lineArray[lineIDE])){
                        System.out.println("Si es una línea válida.");
                    }
                    else {
                        System.out.println("No es una línea válida.");
                    }
                    break;
                case 6:
                    System.out.println("Elegido trainAddCar!");

                    Scanner idF = new Scanner(System.in);
                    System.out.println("Introduzca el ID del tren a modificar: ");
                    int trainIDF= Integer.parseInt(input.nextLine());

                    System.out.println("Se ha elegido el siguiente tren: ");
                    System.out.println(trainArray[trainIDF].traintoString());

                    Scanner pcarID = new Scanner(System.in);
                    System.out.println("Introduzca el ID del carro a introducir en tren de " + trainArray[trainIDF].getTrainMaker() + ": ");
                    int pcarIDInt= Integer.parseInt(input.nextLine());

                    Scanner position = new Scanner(System.in);
                    System.out.println("Introduzca la posición: ");
                    int positionInt= Integer.parseInt(input.nextLine());

                    trainArray[trainIDF] = trainArray[trainIDF].addCar(pcarArray[pcarIDInt], positionInt);

                    System.out.println("Tren actualizado: ");
                    System.out.println(trainArray[trainIDF].traintoString());
                    break;
                case 7:
                    System.out.println("Elegido trainRemoveCar!");

                    Scanner idG = new Scanner(System.in);
                    System.out.println("Introduzca el ID del tren a modificar: ");
                    int trainIDG= Integer.parseInt(input.nextLine());

                    System.out.println("Se ha elegido el siguiente tren: ");
                    System.out.println(trainArray[trainIDG].traintoString());

                    Scanner positionRemove = new Scanner(System.in);
                    System.out.println("Introduzca la posición: ");
                    int positionRemoveInt= Integer.parseInt(input.nextLine());

                    trainArray[trainIDG] = trainArray[trainIDG].removeCar(positionRemoveInt);

                    System.out.println("Tren actualizado: ");
                    System.out.println(trainArray[trainIDG].traintoString());

                    break;
                case 8:
                    System.out.println("Elegido isTrain!");

                    Scanner idH = new Scanner(System.in);
                    System.out.println("Introduzca el ID del tren a verificar: ");
                    int trainIDH= Integer.parseInt(input.nextLine());

                    if(trainArray[trainIDH].isTrain()){
                        System.out.println("Es un tren válido!");
                    }
                    else {
                        System.out.println("No es un tren válido...");
                    }

                    break;
                case 9:
                    System.out.println("Elegido fetchCapacity!");

                    Scanner idI = new Scanner(System.in);
                    System.out.println("Introduzca el ID del tren a operar: ");
                    int trainIDI = Integer.parseInt(input.nextLine());
                    float outputCapacity = trainArray[trainIDI].fetchCapacity();
                    System.out.println("Capacidad total del tren es de: " + outputCapacity);

                    break;
                case 10:
                    System.out.println("Elegido whereIsTrain!");
                    break;
                case 11:
                    System.out.println("Elegido trainPath!");
                    break;
                case 12:
                    System.out.println("Gracias por preferir el sistema de metro, vuelva pronto.");
                    break;
            }
        }
    }
}
