package com.interstellar.transport.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interstellar.transport.form.Edge;
import com.interstellar.transport.form.Graph;

public class DijkstraAlgorithm {

    private final List<String> nodes;
    private final List<Edge> edges;
    private Set<String> settledNodes;
    private Set<String> unSettledNodes;
    private Map<String, String> predecessors;
    private Map<String, Double> distance;

    public DijkstraAlgorithm(Graph graph) {
        // create a copy of the array so that we can operate on this array
        nodes = new ArrayList<>(graph.getVertexes());
        edges = new ArrayList<>(graph.getEdges());
    }

    public void execute(String source) {
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0.00);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            String node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(String node) {
        List<String> adjacentNodes = getNeighbors(node);
        for (String target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private Double getDistance(String node, String target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<String> getNeighbors(String node) {
        List<String> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private String getMinimum(Set<String> Stringes) {
        String minimum = null;
        for (String String : Stringes) {
            if (minimum == null) {
                minimum = String;
            }
            else {
                if (getShortestDistance(String) < getShortestDistance(minimum)) {
                    minimum = String;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(String String) {
        return settledNodes.contains(String);
    }

    public double getShortestDistance(String destination) {
        Double d = distance.get(destination);
        if (d == null) {
            return Double.MAX_VALUE;
        }
        else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and NULL if no path
     * exists
     */
    public LinkedList<String> getPath(String target) {
        LinkedList<String> path = new LinkedList<>();
        String step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

    /*
     * This method returns the path from the source to the selected target and NULL if no path
     * exists
     */
    public LinkedList<String> getOriginToDestinationPath(String target) {
        LinkedList<String> path = new LinkedList<>();
        String step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}