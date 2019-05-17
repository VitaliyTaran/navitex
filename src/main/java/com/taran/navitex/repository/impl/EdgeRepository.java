package com.taran.navitex.repository.impl;

import com.taran.navitex.entity.Edge;
import com.taran.navitex.repository.NavitexRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EdgeRepository implements NavitexRepository<Edge> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Edge find(long id) {
        return null;
    }

    @Override
    public List<Edge> findAll() {
        return null;
    }

    @Override
    public void create(Edge edge) {

    }

    @Override
    public void update(Edge edge) {

    }

    @Override
    public void remove(Edge edge) {

    }

    @Override
    public void remove(long id) {

    }
}
