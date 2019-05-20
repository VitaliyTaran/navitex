package com.taran.navitex.repository.impl;

import com.taran.navitex.entity.Sensor;
import com.taran.navitex.repository.SensorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class SensorRepositoryImpl implements SensorRepository {
    private static final String DELETE_SENSOR_SQL = "DELETE FROM sensor where id=?";
    private static final String FIND_ALL_SENSOR_SQL = "SELECT * FROM sensor";
    private static final String FIND_SENSOR_SQL = "SELECT * FROM sensor where id = ?";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Sensor> find(long id) {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(FIND_SENSOR_SQL, Sensor.class);
        query.setParameter(1, id);
        return Optional.of((Sensor) query.getResultList().get(0));
    }

    @Override
    public List<Sensor> findAll() {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(FIND_ALL_SENSOR_SQL, Sensor.class);
        return query.getResultList();
    }

    @Override
    public void create(Sensor sensor) {
        entityManager.persist(sensor);
    }

    @Override
    public void update(Sensor sensor) {
        entityManager.merge(sensor);
    }

    @Override
    public void remove(Sensor sensor) {
        entityManager.remove(sensor);
    }

    @Override
    public boolean remove(long id) {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(DELETE_SENSOR_SQL, Sensor.class);
        query.setParameter(1, id);
        return query.executeUpdate() == 1;
    }
}
