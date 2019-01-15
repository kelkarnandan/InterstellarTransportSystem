package com.interstellar.transport.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.interstellar.transport.entity.Planet;

/**
 * @author nandan_kelkar
 */
@Transactional
public interface PlanetNameRepository extends CrudRepository<Planet, Long> {
}
