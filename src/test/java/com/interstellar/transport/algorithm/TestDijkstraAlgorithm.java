package com.interstellar.transport.algorithm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.interstellar.transport.entity.Planet;
import com.interstellar.transport.entity.Route;
import com.interstellar.transport.form.Edge;
import com.interstellar.transport.form.Graph;
import com.interstellar.transport.repository.PlanetNameRepository;
import com.interstellar.transport.repository.PlanetRouteRepository;

/**
* @author nandan_kelkar
*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestDijkstraAlgorithm {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlanetNameRepository planetRepository;

    @Autowired
    private PlanetRouteRepository routeRepository;

    private List<String> nodes;
    private List<Edge> edges;

    @Test
    public void testExcute() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        // add Strings from db
        List<Planet> planets = (List<Planet>) planetRepository.findAll();
        for (Planet planet : planets) {
            nodes.add(planet.getPlanetNode());
        }
        // add routes from db
        List<Route> routes = (List<Route>) routeRepository.findAll();
        for (Route route : routes) {
            addEdges(route);
        }

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<String> path = dijkstra.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (String String : path) {
            System.out.println(String);
        }

    }

    private void addEdges(Route route) {
        Edge lane = new Edge(route.getRouteID(), route.getPlanetOrigin(),
                route.getPlanetDesitnation(), route.getPlanetDistance());
        edges.add(lane);
    }
}