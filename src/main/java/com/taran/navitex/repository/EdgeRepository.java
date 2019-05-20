package com.taran.navitex.repository;

import com.taran.navitex.entity.Edge;

import java.util.List;
import java.util.Optional;

public interface EdgeRepository {
    Optional<Edge> find(long first_sensor_id, long second_sensor_id);

    List<Edge> findAll();

    void create(Edge edge);

    void update(Edge edge);

    void remove(Edge edge);

    boolean remove(long first_sensor_id, long second_sensor_id);
}
