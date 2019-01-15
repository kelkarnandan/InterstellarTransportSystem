package com.interstellar.transport.form;

import java.io.Serializable;

public class CalculateDistanceRequest implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String origin;
    private String destination;

    public CalculateDistanceRequest() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return The origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin The origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return The destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination The destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

}
