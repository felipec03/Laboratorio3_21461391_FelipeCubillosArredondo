package org.example;

/**
 * Una sección en un sistema de metro se puede pensar como el tramo que une a dos estaciones
 * Esta tiene por fin determinar la distancia y costo entre la conexión entre las estaciones.
 */
public class TDASection{
    TDAStation point1;
    TDAStation point2;
    float distance;
    float cost;

    /**
     *
     * @param point1 Punto de inicio en la sección
     * @param point2 Punto de fin en la sección
     * @param distance Distancia entre los dos puntos seleccionados
     * @param cost Costo entre los dos puntos seleccionados, variable
     */
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
