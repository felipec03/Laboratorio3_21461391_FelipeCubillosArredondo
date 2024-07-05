package org.example;

public class TDASection {
    TDAStation point1;
    TDAStation point2;
    float distance;
    float cost;

    public TDASection(TDAStation point1, TDAStation point2, float distance, float cost) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
        this.cost = cost;
    }

    public TDAStation getPoint1() {
        return point1;
    }

    public TDAStation getPoint2() {
        return point2;
    }

    public float getDistance() {
        return distance;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "TDASection{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", distance=" + distance +
                ", cost=" + cost +
                '}';
    }
}
