package com.interstellar.transport.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.interstellar.transport.entity.Planet;

/**
 * @author nandan_kelkar
 */
@Transactional
public interface PlanetNameRepository extends CrudRepository<Planet, Long> {

    @Query("select p from Planet p where p.planetNode = :planetNode")
    Planet findByPlanetNode(@Param("planetNode") String planetNode);

    @Modifying
    @Query("delete from Planet p where p.planetNode = :planetNode")
    void deleteByPlanetNode(@Param("planetNode") String planetNode);
}
