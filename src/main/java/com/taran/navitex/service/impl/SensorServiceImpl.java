package com.taran.navitex.service.impl;

import com.taran.navitex.entity.Sensor;
import com.taran.navitex.exception.NavitexServiceException;
import com.taran.navitex.repository.SensorRepository;
import com.taran.navitex.service.SensorService;
import com.taran.navitex.service.util.PositiveNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {
    private static final String NOT_EXIST_MESSAGE = "Country doesn't exist with id = ";
    private static final String INCORRECT_VALUE = " - it's not a long or incorrect value.";
    private SensorRepository sensorRepository;

    @Autowired
    public void setSensorRepository(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor find(String id) throws NavitexServiceException {
        if (PositiveNumberValidator.validate(id)) {
            Optional<Sensor> edge = sensorRepository.find(Long.valueOf(id));
            if (edge.isPresent()) {
                return edge.get();
            } else {
                throw new NavitexServiceException(NOT_EXIST_MESSAGE + id);
            }
        } else {
            throw new NavitexServiceException(id + INCORRECT_VALUE);
        }
    }

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public void create(Sensor sensor) {
        sensorRepository.create(sensor);
    }

    @Override
    public void update(Sensor sensor) {
        sensorRepository.update(sensor);
    }

    @Override
    public void remove(Sensor sensor) {
        sensorRepository.remove(sensor);

    }

    @Override
    public boolean remove(String id) throws NavitexServiceException {
        if (PositiveNumberValidator.validate(id)) {
            return sensorRepository.remove(Long.valueOf(id));
        } else {
            throw new NavitexServiceException(id + INCORRECT_VALUE);
        }
    }
}
