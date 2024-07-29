package org.example;

import java.util.List;

/**
 * Corresponde a la representación de una línea en un sistema de metro
 * Esta contiene, además de atributos descriptivos, una lista con todas las secciones de la linea.
 */

public class TDALine {
    private final int id;
    String name;
    String railType;
    List<TDASection> sectionList;

    /**
     *
     * @param id ID Irrepetible de una línea, llave primaria
     * @param name Nombre de la línea en cuestión
     * @param railType Tipo de riel
     * @param sectionList Lista de secciones que conforman una línea, se asumen que están en órden creciente y ordenado
     */

    public TDALine(int id, String name, String railType, List<TDASection> sectionList) {
        this.id = id;
        this.name = name;
        this.railType = railType;
        this.sectionList = sectionList;
    }

    public String getName() {
        return name;
    }

    public List<TDASection> getSectionList() {
        return sectionList;
    }

    /**
     * @return Dada una instancia de una línea de metro este método devuelve la longitud total de la línea
     */
    public float lineLength(){
        float output = 0;
        for(TDASection section : sectionList){
            output += section.getDistance();
        }
        return output;
    }

    /**
     * @param point1 Nombre de una estación como String, representa el punto de inicio de izquierda a derecha.
     * @param point2 Nombre de una estación como String, representa el punto final de izquierda a derecha.
     * @return Dado dos puntos en una línea devuelve la sublista en el contexto de la instanciación.
     */
    private List<TDASection> getSubsection(String point1, String point2){
        try{
            int firstIndex = 0;
            int lastIndex = 0;
            int counter = 0;
            for(TDASection section : sectionList){
                if((section.getPoint1()).getName().equals(point1)){
                    firstIndex = counter;
                }
                if((section.getPoint2()).getName().equals(point2) ){
                    lastIndex = counter;
                }
                counter++;
            }
            return sectionList.subList(firstIndex, lastIndex + 1);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("ERROR: " + e);
        }
        return sectionList;
    }

    /**
     * @param station1Name Representado cómo String, inicio de la sección
     * @param station2Name Representado cómo String, fin de la sección
     * @return Retorna el largo iniciando del punto 1 al punto 2 en el contexto de la línea instanciada,
     */
    public float lineSectionLength(String station1Name, String station2Name){
        float output = 0;
        List<TDASection> subSections = getSubsection(station1Name, station2Name);
        for(TDASection section : subSections){
            output += section.getDistance();
        }
        return output;
    }

    /**
     * @return Dada una instancia de una línea de metro este método devuelve el costo total de traversar la línea
     */
    public float lineCost(){
        float output = 0;
        for(TDASection section : sectionList){
            output += section.getCost();
        }
        return output;
    }

    /**
     * @param station1Name Representado cómo String, inicio de la sección
     * @param station2Name Representado cómo String, fin de la sección
     * @return Retorna el costo de recorrer iniciando del punto 1 al punto 2 en el contexto de la línea instanciada,
     */
    public float lineSectionCost(String station1Name, String station2Name){
        float output = 0;
        List<TDASection> subSections = getSubsection(station1Name, station2Name);
        for (TDASection section : subSections){
            output += section.getCost();
        }
        return output;
    }

    /**
     * @param section Sección instanciada por archivos
     * @return Nuevo TDALine con la sección añadida al final de la lista de secciones
     */
    public TDALine lineAddSection(TDASection section){
        sectionList.add(section);
        return new TDALine(id, name, railType, sectionList);
    }

    /**
     * @param line Linea a verificar
     * @return true si la línea cumple con los requerimientos: Primera y última estación terminal, etc... false en cualquier otro caso
     */
    public boolean isLine(TDALine line){
        List<TDASection> sectionList = line.getSectionList();
        TDAStation firstStation = (sectionList.get(0)).getPoint1();
        TDAStation lastStation = (sectionList.get(sectionList.size() - 1)).getPoint2();
        boolean firstAndLast = firstStation.getType() == lastStation.getType();
        int counter = 0;
        for (TDASection section : sectionList){
            if(section.getPoint1().getType().equals(StationType.t) ){
                counter = counter + 1;
            }
        }
        return firstAndLast && (counter < 2);
    }

    /**
     * Visualización de la línea
     */
    public void lineToString() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + name);
        System.out.println("Tipo de rail: " + railType);
        for (TDASection section : sectionList) {
            section.sectionToString();
        }
    }
}
