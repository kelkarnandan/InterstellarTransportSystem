package com.interstellar.transport.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.interstellar.transport.entity.Route;
import com.interstellar.transport.repository.PlanetRouteRepository;

@RestController
public class RouteController {

    @Autowired
    private PlanetRouteRepository routeRepository;

    @GetMapping("/routes")
    public List<Route> retrieveAllRoutes() {
        return routeRepository.findAll();
    }

    @GetMapping("/routes/{id}")
    public Route retrieveRoute(@PathVariable long id) {
        Optional<Route> route = routeRepository.findById(id);

        return route.get();
    }

    @DeleteMapping("/routes/{id}")
    public void deleteRoute(@PathVariable long id) {
        routeRepository.deleteById(id);
        ;
    }

    @PostMapping("/routes")
    public ResponseEntity<Object> createRoute(@RequestBody Route route) {
        Route savedRoute = routeRepository.save(route);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedRoute.getRouteID()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/routes/{id}")
    public ResponseEntity<Object> updateRoute(@RequestBody Route route, @PathVariable long id) {

        Optional<Route> routeFromdb = routeRepository.findById(id);

        if (!routeFromdb.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Route routeToUpdate = routeFromdb.get();
        routeToUpdate.setPlanetDesitnation(route.getPlanetDesitnation());
        routeToUpdate.setPlanetOrigin(route.getPlanetOrigin());
        routeToUpdate.setPlanetDistance(route.getPlanetDistance());

        routeRepository.save(routeToUpdate);

        return ResponseEntity.noContent().build();
    }

}
