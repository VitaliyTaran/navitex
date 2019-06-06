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

public class AlgorithmDijkstraByDistance {
    private Graph graph;
    private AlgorithmDijkstra algorithm;

    @Before
    public void setUp() {
        TestCollections testCollections = new TestCollections();
        graph = testCollections.getGraph();
        algorithm = new AlgorithmDijkstra(TypeAlgorithm.BY_DISTANCE);
    }

    @Test
    public void execute() throws NavitexLogicAlgorithmException {
        List<Sensor> actual = new ArrayList<>();
        actual.add(graph.getSensors().get(0));
        actual.add(graph.getSensors().get(5));
        actual.add(graph.getSensors().get(2));
        algorithm.execute(graph, graph.getSensors().get(0), graph.getSensors().get(2));
        Assert.assertEquals(algorithm.calculatePath(), actual);

    }

    @Test
    public void calculatePath() throws NavitexLogicAlgorithmException {
        List<Sensor> actual = new ArrayList<>();
        actual.add(graph.getSensors().get(0));
        actual.add(graph.getSensors().get(5));
        actual.add(graph.getSensors().get(4));
        algorithm.execute(graph, graph.getSensors().get(0), graph.getSensors().get(4));
        Assert.assertEquals(algorithm.calculatePath(), actual);
    }

    @Test
    public void calculateCost() {
        Edge edge = graph.getEdges().get(1);
        algorithm.execute(graph, edge.getFirst(), edge.getSecond());

        Assert.assertEquals(algorithm.calculateCost(), 1384);
    }
}
