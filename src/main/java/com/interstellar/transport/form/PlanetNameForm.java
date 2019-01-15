package com.interstellar.transport.form;

/**
 * @author nandan_kelkar
 */

public class PlanetNameForm {

    private Long id;
    private String planetNode;
    private String planetName;

    /**
     * @return The id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The id to set
     */
    public void setId(Long id) {
        this.id = id;
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

}
