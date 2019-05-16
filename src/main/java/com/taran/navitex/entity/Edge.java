package com.taran.navitex.entity;


public class Edge {
    private final Point first;
    private final Point second;
    private final int cost;

    public Edge(Point first, Point second, int cost) {
        this.first = first;
        this.second = second;
        this.cost = cost;
    }

    public Point getSecond() {
        return second;
    }

    public Point getFirst() {
        return first;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "first=" + first +
                ", second=" + second +
                ", cost=" + cost +
                '}';
    }

    public static Edge createInvertEdge(Edge edge) {
        return new Edge(edge.second, edge.first, edge.cost);
    }
}
