package com.taran.navitex.logic;

import com.taran.navitex.data.TestCollections;
import com.taran.navitex.entity.Edge;
import com.taran.navitex.entity.Graph;
import com.taran.navitex.entity.Sensor;
import com.taran.navitex.entity.TypeAlgorithm;
import com.taran.navitex.exception.NavitexLogicAlgorithmException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmDijkstraByCostTest {
    private Graph graph;
    private AlgorithmDijkstra algorithm;

    @Before
    public void setUp() {
        TestCollections testCollections = new TestCollections();
        graph = testCollections.getGraph();
        algorithm = new AlgorithmDijkstra(TypeAlgorithm.BY_COST);
    }

    @Test
    public void execute() throws NavitexLogicAlgorithmException {
        List<Sensor> actualWay = new ArrayList<>();
        actualWay.add(graph.getSensors().get(1));
        actualWay.add(graph.getSensors().get(2));
        actualWay.add(graph.getSensors().get(3));
        algorithm.execute(graph, graph.getSensors().get(1), graph.getSensors().get(3));
        Assert.assertEquals(algorithm.calculatePath(), actualWay);
    }

    @Test
    public void calculatePath() throws NavitexLogicAlgorithmException {
        List<Sensor> actualWay = new ArrayList<>();
        actualWay.add(graph.getSensors().get(0));
        actualWay.add(graph.getSensors().get(5));
        actualWay.add(graph.getSensors().get(4));
        actualWay.add(graph.getSensors().get(3));
        Sensor first = graph.getSensors().get(0);
        Sensor second = graph.getSensors().get(3);
        algorithm.execute(graph, first, second);
        graph.getEdges().forEach(System.out::println);
        System.out.println(algorithm.calculatePath());
        Assert.assertEquals(algorithm.calculatePath(), actualWay);
    }

    @Test
    public void calculateCost() {
        Edge edge = graph.getEdges().get(1);
        algorithm.execute(graph, edge.getFirst(), edge.getSecond());

        Assert.assertEquals(algorithm.calculateCost(), 9691);
    }
}