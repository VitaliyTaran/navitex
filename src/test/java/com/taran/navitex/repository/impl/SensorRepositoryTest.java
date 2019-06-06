package com.taran.navitex.repository.impl;

import com.taran.navitex.configuration.TestApplicationContext;
import com.taran.navitex.data.TestCollections;
import com.taran.navitex.entity.Sensor;
import com.taran.navitex.repository.SensorRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationContext.class})
public class SensorRepositoryTest {
    @Autowired
    private SensorRepository repository;
    private List<Sensor> sensorList;
    private Sensor testSensor;


    @Before
    public void setUp() {
        TestCollections testCollections = new TestCollections();
        sensorList = testCollections.getSensorList();
        testSensor = new Sensor("7", 75.7575, 54.5454);
    }

    @Test
    public void find() {
        Sensor expected = repository.find(1).get();
        Sensor actual = sensorList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        List<Sensor> expected = repository.findAll();
        Assert.assertEquals(expected, sensorList);
    }

    @Test
    public void create() {
        repository.create(testSensor);
        sensorList.add(testSensor);

        List<Sensor> expected = repository.findAll();
        Assert.assertEquals(expected, sensorList);
    }


    @Test
    public void remove() {
        repository.remove(7);
        sensorList.remove(6);

        List<Sensor> expected = repository.findAll();
        Assert.assertEquals(expected, sensorList);
    }
}