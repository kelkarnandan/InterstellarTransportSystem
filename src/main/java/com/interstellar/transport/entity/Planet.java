package com.interstellar.transport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nandan_kelkar
 */

@Entity
@Table(name = "PLANET_NAME")
public class Planet {

    @Id
    @Column(name = "planet_node")
    private String planetNode;
    @Column(name = "planet_name")
    private String planetName;

    /**
     * 
     */
    public Planet() {
        super();
    }

    /**
     * @param planetNode
     * @param planetName
     */
    public Planet(String planetNode, String planetName) {
        super();
        this.planetNode = planetNode;
        this.planetName = planetName;
    }

    /**
     * @return The planetNode
     */
    public String getPlanetNode() {
        return planetNode;
    }

    /**
     * @param planetNode The planetNode to set
     */
    public void setPlanetNode(String planetNode) {
        this.planetNode = planetNode;
    }

    /**
     * @return The planetName
     */
    public String getPlanetName() {
        return planetName;
    }

    /**
     * @param planetName The planetName to set
     */
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((planetName == null) ? 0 : planetName.hashCode());
        result = prime * result + ((planetNode == null) ? 0 : planetNode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Planet other = (Planet) obj;
        if (planetName == null) {
            if (other.planetName != null) {
                return false;
            }
        }
        else if (!planetName.equals(other.planetName)) {
            return false;
        }
        if (planetNode == null) {
            if (other.planetNode != null) {
                return false;
            }
        }
        else if (!planetNode.equals(other.planetNode)) {
            return false;
        }
        return true;
    }

}
