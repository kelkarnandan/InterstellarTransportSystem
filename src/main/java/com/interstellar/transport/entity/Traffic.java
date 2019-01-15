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
@Table(name = "Traffic")
public class Traffic {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "traffic_id")
    private Long trafficID;
    @Column(name = "planet_origin")
    private String planetOrigin;
    @Column(name = "planet_destination")
    private String planetDesitnation;
    @Column(name = "traffic")
    private Long planetTrafficDelay;

    /**
     * @return The id
     */
    public Long getId() {
        return trafficID;
    }

    /**
     * @param id The id to set
     */
    public void setId(Long id) {
        trafficID = id;
    }

    /**
     * @return The planetNode
     */
    public String getPlanetNode() {
        return planetOrigin;
    }

    /**
     * @param planetNode The planetNode to set
     */
    public void setPlanetNode(String planetNode) {
        planetOrigin = planetNode;
    }

    /**
     * @return The planetName
     */
    public String getPlanetName() {
        return planetDesitnation;
    }

    /**
     * @param planetName The planetName to set
     */
    public void setPlanetName(String planetName) {
        planetDesitnation = planetName;
    }

    /**
     * @return The planetTrafficDelay
     */
    public Long getPlanetTrafficDelay() {
        return planetTrafficDelay;
    }

    /**
     * @param planetTrafficDelay The planetTrafficDelay to set
     */
    public void setPlanetTrafficDelay(Long planetTrafficDelay) {
        this.planetTrafficDelay = planetTrafficDelay;
    }

}
