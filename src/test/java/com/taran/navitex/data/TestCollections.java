package com.taran.navitex.data;

import com.taran.navitex.entity.Edge;
import com.taran.navitex.entity.Graph;
import com.taran.navitex.entity.Sensor;

import java.util.ArrayList;
import java.util.List;

public class TestCollections {
    private List<Sensor> sensorList;
    private List<Edge> edgeList;
    private Graph graph;

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public Graph getGraph() {
        return graph;
    }

    public TestCollections() {
        init();
    }

    private void init() {
        initSensorList();
        initEdgeList();
        graph = new Graph(sensorList, edgeList);

    }

    private void initSensorList() {
        sensorList = new ArrayList<>();
        sensorList.add(new Sensor(1, "1", 72.14034, 169.67485));
        sensorList.add(new Sensor(2, "2", -56.73142, 178.15685));
        sensorList.add(new Sensor(3, "3", -37.46646, -88.29196));
        sensorList.add(new Sensor(4, "4", 27.52873, -67.69225));
        sensorList.add(new Sensor(5, "5", 71.54185, -79.73339));
        sensorList.add(new Sensor(6, "6", 32.185, -43.73339));
    }

    private void initEdgeList() {
        edgeList = new ArrayList<>();
        edgeList.add(new Edge(1, sensorList.get(0), sensorList.get(1), 1));
        edgeList.add(new Edge(2, sensorList.get(1), sensorList.get(0), 1));
        edgeList.add(new Edge(3, sensorList.get(1), sensorList.get(2), 1));
        edgeList.add(new Edge(4, sensorList.get(2), sensorList.get(1), 1));
        edgeList.add(new Edge(5, sensorList.get(2), sensorList.get(3), 1));
        edgeList.add(new Edge(6, sensorList.get(3), sensorList.get(2), 1));
        edgeList.add(new Edge(7, sensorList.get(3), sensorList.get(4), 1));
        edgeList.add(new Edge(8, sensorList.get(4), sensorList.get(3), 1));
        edgeList.add(new Edge(9, sensorList.get(4), sensorList.get(0), 1));
        edgeList.add(new Edge(10, sensorList.get(0), sensorList.get(4), 1));
    }

}
