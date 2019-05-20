package com.taran.navitex.service;

import com.taran.navitex.entity.Edge;
import com.taran.navitex.exception.NavitexServiceException;

import java.util.List;

public interface EdgeService {
    Edge find(String first_sensor_id, String second_sensor_id) throws NavitexServiceException;

    List<Edge> findAll();

    void create(Edge edge);

    void update(Edge edge);

    void remove(Edge edge);

    boolean remove(String first_sensor_id, String second_sensor_id) throws NavitexServiceException;
}
