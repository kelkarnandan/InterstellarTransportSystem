package com.interstellar.transport.controller;

import java.net.URI;
import java.util.List;

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

import com.interstellar.transport.entity.Planet;
import com.interstellar.transport.repository.PlanetNameRepository;

@RestController
public class PlanetController {

    @Autowired
    private PlanetNameRepository planetRepository;

    @GetMapping("/planets")
    public List<Planet> retrieveAllPlanets() {
        return (List<Planet>) planetRepository.findAll();
    }

    @GetMapping("/planets/{planetNode}")
    public Planet retrievePlanet(@PathVariable String planetNode) {
        Planet planet = planetRepository.findByPlanetNode(planetNode);

        return planet;
    }

    @DeleteMapping("/planets/{planetNode}")
    public void deletePlanet(@PathVariable String planetNode) {
        planetRepository.deleteByPlanetNode(planetNode);
    }

    @PostMapping("/planets")
    public ResponseEntity<Object> createPlanet(@RequestBody Planet planet) {
        Planet savedPlanet = planetRepository.save(planet);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{planetNode}")
                .buildAndExpand(savedPlanet.getPlanetNode()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/planets/{planetNode}")
    public ResponseEntity<Object> updatePlanet(@RequestBody Planet planet,
            @PathVariable String planetNode) {

        Planet planetFromdb = planetRepository.findByPlanetNode(planetNode);

        if (planetFromdb == null) {
            return ResponseEntity.notFound().build();
        }

        planetFromdb.setPlanetName(planet.getPlanetName());

        planetRepository.save(planetFromdb);

        return ResponseEntity.noContent().build();
    }
}
