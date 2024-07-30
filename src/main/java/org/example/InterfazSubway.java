package org.example;

import java.util.List;

public interface InterfazSubway {
    TDASubway addTrain(List<TDATrain> trainList);
    TDASubway addLine(List<TDALine> lineList);
    TDASubway addDrivers(List<TDADriver> driverList);
    void SubwayToString();
}
