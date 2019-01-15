package com.interstellar.transport.form;

import java.io.Serializable;

public class CalculateDistanceResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String path;
    private Double distance;

    public CalculateDistanceResponse(String path, Double distance) {
        this.path = path;
        this.distance = distance;
    }

    /**
     * @return The path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path The path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return The distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * @param distance The distance to set
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

}
