package com.interstellar.transport.form;

public class Edge {

    private final Long id;
    private final String source;
    private final String destination;
    private final Double weight;

    /**
     * @return The id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return The source
     */
    public String getSource() {
        return source;
    }

    /**
     * @return The destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @return The weight
     */
    public Double getWeight() {
        return weight;
    }

    public Edge(Long long1, String source, String destination, Double long2) {
        id = long1;
        this.source = source;
        this.destination = destination;
        weight = long2;
    }

    @Override
    public String toString() {
        return source + " " + destination + " " + weight;
    }

}