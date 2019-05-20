package com.taran.navitex.repository.impl;

import com.taran.navitex.configuration.TestApplicationContext;
import com.taran.navitex.data.TestCollections;
import com.taran.navitex.entity.Edge;
import com.taran.navitex.entity.Sensor;
import com.taran.navitex.repository.EdgeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationContext.class})
public class EdgeRepositoryTest {
    @Autowired
    private EdgeRepository repository;
    private List<Edge> edgeList;
    private List<Sensor> sensorList;
    private Edge testEdge;

    @Before
    public void setUp() {
        TestCollections testCollections = new TestCollections();
        edgeList = testCollections.getEdgeList();
        sensorList = testCollections.getSensorList();
        testEdge = new Edge(sensorList.get(6), sensorList.get(0));
    }

    @Test
    public void find() {
        Optional<Edge> expected = repository.find(1, 2);
        Optional<Edge> actual = edgeList.stream().filter(o -> o.getFirst().getId() == 1 && o.getSecond().getId() == 2).findFirst();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        List<Edge> expected = repository.findAll();
        Assert.assertEquals(expected, edgeList);
    }

    @Test
    public void create() { ;
        repository.create(testEdge);
        edgeList.add(testEdge);
        List<Edge> expected = repository.findAll();
        Assert.assertEquals(expected, edgeList);
    }

    @Test
    public void update() {
        testEdge.setId(1);
        repository.update(testEdge);
        edgeList.set(0, testEdge);
        List<Edge> expected = repository.findAll();
        Assert.assertEquals(expected, edgeList);
    }

    @Test
    public void remove() {
        repository.remove(1, 2);
        Optional<Edge> first = edgeList.stream()
                .filter(o -> o.getFirst().getId() == 1 && o.getSecond().getId() == 2)
                .findFirst();
        edgeList.remove(first.get());
        Assert.assertEquals(repository.findAll(), edgeList);
    }


}