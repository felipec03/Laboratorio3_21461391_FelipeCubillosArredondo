package org.example;

import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    public void mostrarOpciones(){
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
    public void startMenu(TDAStation[] stationArray, TDASection[] sectionArray, TDALine[] lineArray, TDAPassengerCar[] pcarArray, TDATrain[] trainArray, TDADriver[] driverArray){
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
                    break;
                case 7:
                    System.out.println("Elegido trainRemoveCar!");
                    break;
                case 8:
                    System.out.println("Elegido isTrain!");
                    break;
                case 9:
                    System.out.println("Elegido fetchCapacity!");
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
