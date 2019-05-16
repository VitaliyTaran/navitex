package com.taran.navitex.entity;

import java.util.List;

public class Graph {
    private final List<Point> points;
    private final List<Edge> edges;


    public Graph(List<Point> points, List<Edge> edges) {
        this.points = points;
        this.edges = edges;
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
