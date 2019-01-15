package com.interstellar.transport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * @author nandan_kelkar
 */

@Entity
@Table(name = "Route")
public class Route {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Long routeID;
    @Column(name = "planet_Origin")
    private String planetOrigin;
    @Column(name = "planet_Destination")
    private String planetDesitnation;
    @Column(name = "planet_Distance")
    private Double planetDistance;

    /**
     * 
     */
    public Route() {
        super();
    }

    /**
     * @return The routeID
     */
    public Long getRouteID() {
        return routeID;
    }

    /**
     * @param routeID The routeID to set
     */
    public void setRouteID(Long routeID) {
        this.routeID = routeID;
    }

    /**
     * @return The planetOrigin
     */
    public String getPlanetOrigin() {
        return planetOrigin;
    }

    /**
     * @param planetOrigin The planetOrigin to set
     */
    public void setPlanetOrigin(String planetOrigin) {
        this.planetOrigin = planetOrigin;
    }

    /**
     * @return The planetDesitnation
     */
    public String getPlanetDesitnation() {
        return planetDesitnation;
    }

    /**
     * @param planetDesitnation The planetDesitnation to set
     */
    public void setPlanetDesitnation(String planetDesitnation) {
        this.planetDesitnation = planetDesitnation;
    }

    /**
     * @return The planetDistance
     */
    public Double getPlanetDistance() {
        return planetDistance;
    }

    /**
     * @param planetDistance The planetDistance to set
     */
    public void setPlanetDistance(Double planetDistance) {
        this.planetDistance = planetDistance;
    }

    @Override
    public String toString() {
        return "Route [planetOrigin=" + planetOrigin + ", planetDesitnation=" + planetDesitnation
                + ", planetDistance=" + planetDistance + "]";
    }

}
