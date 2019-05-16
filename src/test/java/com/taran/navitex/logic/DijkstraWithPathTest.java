package com.taran.navitex.logic;

import com.taran.navitex.entity.Edge;
import com.taran.navitex.entity.Graph;
import com.taran.navitex.entity.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DijkstraWithPathTest {

    @Test
    public void dijkstraRMQ() {
        List<Edge> edgeList = new ArrayList<>();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            pointList.add(new Point(i, String.valueOf(i)));
        }
        edgeList.add(new Edge(pointList.get(0), pointList.get(1), 1));
        edgeList.add(new Edge(pointList.get(0), pointList.get(3), 5));
        edgeList.add(new Edge(pointList.get(1), pointList.get(2), 2));
        edgeList.add(new Edge(pointList.get(2), pointList.get(3), 1));
        edgeList.add(new Edge(pointList.get(3), pointList.get(4), 1));
        edgeList.add(new Edge(pointList.get(4), pointList.get(5), 2));
        edgeList.add(new Edge(pointList.get(4), pointList.get(6), 4));
        edgeList.add(new Edge(pointList.get(5), pointList.get(6), 1));


        Graph graph = new Graph(pointList, edgeList);
        AlgorithmDijkstra dijkstra = new AlgorithmDijkstra();
        dijkstra.execute(graph, 0, 6);
        System.out.println(dijkstra.getCost());
        System.out.println(dijkstra.getRecoveredPath());
    }
}