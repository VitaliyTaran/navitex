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
        sensorList.add(new Sensor(1, "Академия Связи", 53.924594, 27.666809, 1));
        sensorList.add(new Sensor(2, "ст.м Борисовский Тракт", 53.938628, 27.666080, 1));
        sensorList.add(new Sensor(3, "ст.м Восток", 53.934525, 27.651063, 1));
        sensorList.add(new Sensor(4, "мост ул Филимонова и пр. Независимости", 53.931015, 27.638782, 1));
        sensorList.add(new Sensor(5, "ул Ф.Скорины и Филимонова", 53.929377, 27.639395, 1));
        sensorList.add(new Sensor(6, "ул Ф.Скорины проезд Дачный", 53.926973, 27.655037, 1));
        sensorList.add(new Sensor(7, "БНТУ к20", 53.931090, 27.668435, 1));
    }

    private void initEdgeList() {
        edgeList = new ArrayList<>();
        edgeList.add(new Edge(1,sensorList.get(0), sensorList.get(1)));
        edgeList.add(new Edge(2,sensorList.get(1), sensorList.get(0)));

        edgeList.add(new Edge(3,sensorList.get(1), sensorList.get(2)));
        edgeList.add(new Edge(4,sensorList.get(2), sensorList.get(1)));

        edgeList.add(new Edge(5,sensorList.get(2), sensorList.get(3)));
        edgeList.add(new Edge(6,sensorList.get(3), sensorList.get(2)));

        edgeList.add(new Edge(7,sensorList.get(3), sensorList.get(4)));
        edgeList.add(new Edge(8,sensorList.get(4), sensorList.get(3)));

        edgeList.add(new Edge(9,sensorList.get(4), sensorList.get(5)));
        edgeList.add(new Edge(10,sensorList.get(5), sensorList.get(4)));

        edgeList.add(new Edge(11,sensorList.get(5), sensorList.get(2)));
        edgeList.add(new Edge(12,sensorList.get(2), sensorList.get(5)));

        edgeList.add(new Edge(13,sensorList.get(5), sensorList.get(0)));
        edgeList.add(new Edge(14,sensorList.get(0), sensorList.get(5)));
    }
}