package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TDALine {
    int id;
    String name;
    String railType;
    List<TDASection> sectionList;

    public TDALine(int id, String name, String railType, List<TDASection> sectionList) {
        this.id = id;
        this.name = name;
        this.railType = railType;
        this.sectionList = sectionList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRailType() {
        return railType;
    }

    public List<TDASection> getSectionList() {
        return sectionList;
    }

    public float lineLength(){
        float output = 0;
        for(TDASection section : sectionList){
            output += section.getDistance();
        }
        return output;
    }

    List<TDASection> getSubsection(String point1, String point2){
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
        return sectionList.subList(firstIndex, lastIndex);
    }
    public float lineSectionLength(String station1Name, String station2Name){
        float output = 0;
        List<TDASection> subSections = getSubsection(station1Name, station2Name);

        return output;
    }

    public float lineCost(){
        float output = 0;
        for(TDASection section : sectionList){
            output += section.getCost();
        }
        return output;
    }

    public float lineSectionCost(String station1Name, String station2Name){
        float output = 0;
        return output;
    }

    public TDALine lineAddSection(TDASection section){
        sectionList.add(section);
        TDALine NewLine = new TDALine(id, name, railType, sectionList);
        return NewLine;
    }

    public boolean isLine(TDALine line){
        List<TDASection> sectionList = line.getSectionList();
        TDAStation firstStation = (sectionList.get(0)).getPoint1();
        TDAStation lastStation = (sectionList.get(sectionList.size() - 1)).getPoint2();
        boolean firstAndLast = firstStation.getType() == lastStation.getType();
        int counter = 0;
        for (TDASection section : sectionList){
            counter = counter + 1;
        }
        return false;
    }
}
