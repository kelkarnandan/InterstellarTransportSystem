package com.interstellar.transport.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.interstellar.transport.entity.Route;

@Repository
@Transactional
public class RouteService {

    @PersistenceContext
    private EntityManager entityManager;

    public RouteService() {
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
    public List<Route> findAll() {
        Query query = entityManager.createNamedQuery("query_find_all_routes", Route.class);
        return query.getResultList();
    }

}
