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
    public void startMenu(){
        int opcion = 0;
        mostrarOpciones();
        while(opcion != 12){
            Scanner input = new Scanner(System.in);
            System.out.println("Introduzca una opción: ");

            opcion = Integer.parseInt(input.nextLine());

            switch(opcion){
                case 1:
                    System.out.println("Elegido lineLength!");
                    break;
                case 2:
                    System.out.println("Elegido lineSectionLength!");
                    break;
                case 3:
                    System.out.println("Elegido lineCost!");
                    break;
                case 4:
                    System.out.println("Elegido lineSectionCost!");
                    break;
                case 5:
                    System.out.println("Elegido isLine!");
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
