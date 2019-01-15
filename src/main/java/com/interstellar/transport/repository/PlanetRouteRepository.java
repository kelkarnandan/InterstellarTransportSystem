package com.interstellar.transport.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interstellar.transport.entity.Route;

/**
 * @author nandan_kelkar
 */
@Transactional
public interface PlanetRouteRepository extends JpaRepository<Route, Long> {
}
