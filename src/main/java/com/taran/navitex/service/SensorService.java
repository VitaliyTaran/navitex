package com.taran.navitex.service;

import com.taran.navitex.entity.Sensor;
import com.taran.navitex.exception.NavitexServiceException;

import java.util.List;

public interface SensorService {
    Sensor find(String id) throws NavitexServiceException;

    List<Sensor> findAll();

    void create(Sensor sensor);

    void update(Sensor sensor);

    void remove(Sensor sensor);

    boolean remove(String id) throws NavitexServiceException;
}
