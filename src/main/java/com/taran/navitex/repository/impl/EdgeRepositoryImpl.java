package com.taran.navitex.repository.impl;

import com.taran.navitex.entity.Edge;
import com.taran.navitex.repository.EdgeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class EdgeRepositoryImpl implements EdgeRepository {
    private static final String DELETE_EDGE_SQL = "DELETE FROM edge where first_sensor_id=? and second_sensor_id=?";
    private static final String FIND_ALL_EDGE_SQL = "SELECT * FROM edge";
    private static final String FIND_EDGE_SQL = "SELECT * FROM edge where first_sensor_id=? and second_sensor_id=?";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Edge> find(long first_sensor_id, long second_sensor_id) {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(FIND_EDGE_SQL);
        query.setParameter(1, first_sensor_id);
        query.setParameter(2, second_sensor_id);
        return Optional.of((Edge) query.getSingleResult());
    }

    @Override
    public List<Edge> findAll() {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(FIND_ALL_EDGE_SQL, Edge.class);
        return query.getResultList();
    }

    @Override
    public void create(Edge edge) {
        entityManager.persist(edge);

    }

    @Override
    public void update(Edge edge) {
        entityManager.merge(edge);

    }

    @Override
    public void remove(Edge edge) {
        entityManager.remove(edge);
    }

    @Override
    public boolean remove(long first_sensor_id, long second_sensor_id) {
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(DELETE_EDGE_SQL);
        query.setParameter(1, first_sensor_id);
        query.setParameter(2, second_sensor_id);
        return query.executeUpdate() == 1;
    }
}
