package com.taran.navitex.service.impl;

import com.taran.navitex.entity.Edge;
import com.taran.navitex.exception.NavitexServiceException;
import com.taran.navitex.repository.EdgeRepository;
import com.taran.navitex.service.EdgeService;
import com.taran.navitex.service.util.PositiveNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdgeServiceImpl implements EdgeService {
    private static final String NOT_EXIST_MESSAGE = "Country doesn't exist with id = ";
    private static final String INCORRECT_VALUE = " - it's not a long or incorrect value.";
    private EdgeRepository edgeRepository;

    @Autowired
    public void setEdgeRepository(EdgeRepository edgeRepository) {
        this.edgeRepository = edgeRepository;
    }

    @Override
    public Edge find(String first_sensor_id, String second_sensor_id) throws NavitexServiceException {
        if (PositiveNumberValidator.validate(first_sensor_id) && PositiveNumberValidator.validate(second_sensor_id)) {
            Optional<Edge> edge = edgeRepository.find(Long.valueOf(first_sensor_id), Long.valueOf(second_sensor_id));
            if (edge.isPresent()) {
                return edge.get();
            } else {
                throw new NavitexServiceException(NOT_EXIST_MESSAGE + first_sensor_id + ' ' + second_sensor_id);
            }
        } else {
            throw new NavitexServiceException(first_sensor_id + " and " + second_sensor_id + INCORRECT_VALUE);
        }
    }

    @Override
    public List<Edge> findAll() {
        return edgeRepository.findAll();
    }

    @Override
    public void create(Edge edge) {
        edgeRepository.create(edge);
    }

    @Override
    public void update(Edge edge) {
        edgeRepository.update(edge);
    }

    @Override
    public void remove(Edge edge) {
        edgeRepository.remove(edge);

    }

    @Override
    public boolean remove(String first_sensor_id, String second_sensor_id) throws NavitexServiceException {
        if (PositiveNumberValidator.validate(first_sensor_id) && PositiveNumberValidator.validate(second_sensor_id)) {
            return edgeRepository.remove(Long.valueOf(first_sensor_id), Long.valueOf(second_sensor_id));
        } else {
            throw new NavitexServiceException(first_sensor_id + " and " + second_sensor_id + INCORRECT_VALUE);
        }
    }
}
