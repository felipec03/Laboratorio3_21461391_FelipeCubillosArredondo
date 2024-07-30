package org.example;

import java.util.List;

public interface InterfazLine {
    String getName();
    List<TDASection> getSectionList();
    float lineLength();
    List<TDASection> getSubsection(String point1, String point2);
    float lineSectionLength(String station1Name, String station2Name);
    float lineCost();
    float lineSectionCost(String station1Name, String station2Name);
    TDALine lineAddSection(TDASection section);
    boolean isLine(TDALine line);
    void lineToString();
}
