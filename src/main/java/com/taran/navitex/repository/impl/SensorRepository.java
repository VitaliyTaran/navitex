package com.taran.navitex.repository.impl;

import com.taran.navitex.entity.Sensor;
import com.taran.navitex.repository.NavitexRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SensorRepository implements NavitexRepository<Sensor> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Sensor find(long id) {
        return null;
    }

    @Override
    public List<Sensor> findAll() {
        return null;
    }

    @Override
    public void create(Sensor sensor) {

    }

    @Override
    public void update(Sensor sensor) {

    }

    @Override
    public void remove(Sensor sensor) {

    }

    @Override
    public void remove(long id) {

    }
}
