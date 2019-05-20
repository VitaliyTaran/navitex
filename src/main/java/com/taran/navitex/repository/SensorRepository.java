package com.taran.navitex.repository;

import com.taran.navitex.entity.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorRepository {
    Optional<Sensor> find(long id);

    List<Sensor> findAll();

    void create(Sensor sensor);

    void update(Sensor sensor);

    void remove(Sensor sensor);

    boolean remove(long id);
}
