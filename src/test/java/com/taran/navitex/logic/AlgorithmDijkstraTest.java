package com.taran.navitex.logic;

import com.taran.navitex.data.TestCollections;
import com.taran.navitex.entity.Edge;
import com.taran.navitex.entity.Graph;
import com.taran.navitex.entity.Sensor;
import com.taran.navitex.exception.NavitexLogicAlgorithmException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmDijkstraTest {
    private Graph graph;
    private AlgorithmDijkstra algorithm;

    @Before
    public void setUp() {
        TestCollections testCollections = new TestCollections();
        graph = testCollections.getGraph();
        algorithm = new AlgorithmDijkstra();
    }

    @Test
    public void execute() throws NavitexLogicAlgorithmException {
        List<Sensor> actualWay = new ArrayList<>();
        actualWay.add(graph.getPoints().get(1));
        actualWay.add(graph.getPoints().get(2));
        actualWay.add(graph.getPoints().get(3));

        Sensor first = graph.getPoints().get(1);
        Sensor second = graph.getPoints().get(3);
        algorithm.execute(graph, first, second);

        Assert.assertEquals(algorithm.calculatePath(), actualWay);
    }

    @Test
    public void calculatePath() throws NavitexLogicAlgorithmException {
        List<Sensor> actualWay = new ArrayList<>();
        actualWay.add(graph.getPoints().get(0));
        actualWay.add(graph.getPoints().get(4));
        actualWay.add(graph.getPoints().get(3));

        Sensor first = graph.getPoints().get(0);
        Sensor second = graph.getPoints().get(3);
        algorithm.execute(graph, first, second);

        Assert.assertEquals(algorithm.calculatePath(), actualWay);
    }

    @Test
    public void calculateCost() {
        Edge edge = graph.getEdges().get(1);
        algorithm.execute(graph, edge.getFirst(), edge.getSecond());

        Assert.assertEquals(algorithm.calculateCost(), edge.getCost());
    }
}