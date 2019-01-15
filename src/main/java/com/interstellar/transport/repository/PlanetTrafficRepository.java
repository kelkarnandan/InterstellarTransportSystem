package com.interstellar.transport.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.interstellar.transport.entity.Traffic;

/**
 * @author nandan_kelkar
 */

@Transactional
public interface PlanetTrafficRepository extends CrudRepository<Traffic, Long> {
}
