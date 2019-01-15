package com.interstellar.transport.form;

import java.util.List;

public class Graph {

    private final List<String> vertexes;
    private final List<Edge> edges;

    public Graph(List<String> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    /**
     * @return The edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * @return The vertexes
     */
    public List<String> getVertexes() {
        return vertexes;
    }

}