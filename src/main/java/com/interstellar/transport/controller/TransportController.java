package com.interstellar.transport.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interstellar.transport.algorithm.DijkstraAlgorithm;
import com.interstellar.transport.entity.Planet;
import com.interstellar.transport.entity.Route;
import com.interstellar.transport.form.CalculateDistanceRequest;
import com.interstellar.transport.form.CalculateDistanceResponse;
import com.interstellar.transport.form.Edge;
import com.interstellar.transport.form.Graph;
import com.interstellar.transport.repository.PlanetNameRepository;
import com.interstellar.transport.repository.PlanetRouteRepository;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private PlanetNameRepository planetRepository;

    @Autowired
    private PlanetRouteRepository routeRepository;

    private List<String> nodes;
    private List<Edge> edges;
    private String origin;
    private String destination;

    @PostMapping("/distance")
    public CalculateDistanceResponse transfer(
            @Valid @RequestBody CalculateDistanceRequest calculateDistanceRequest) {
        origin = calculateDistanceRequest.getOrigin();
        destination = calculateDistanceRequest.getDestination();
        return calculatePathAndDistance();
    }

    public CalculateDistanceResponse calculatePathAndDistance() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        // add planets from db
        List<Planet> planets = (List<Planet>) planetRepository.findAll();
        for (Planet planet : planets) {
            nodes.add(planet.getPlanetNode());
        }
        // add routes from db
        List<Route> routes = routeRepository.findAll();
        for (Route route : routes) {
            addEdges(route);
        }

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(origin);
        LinkedList<String> path = dijkstra.getOriginToDestinationPath(destination);
        Double distance = dijkstra.getShortestDistance(destination);
        return path != null ? new CalculateDistanceResponse(path.toString(), distance)
                : new CalculateDistanceResponse("Not Found", 0.0);

    }

    private void addEdges(Route route) {
        Edge lane = new Edge(route.getRouteID(), route.getPlanetOrigin(),
                route.getPlanetDesitnation(), route.getPlanetDistance());
        edges.add(lane);
    }

}
