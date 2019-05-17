package com.taran.navitex.logic.util;

public class MultiList {
    private int[] head;
    private int[] next;
    private int[] vert;
    private int[] cost;
    private int cnt = 1;

    public MultiList(int pointsNumber, int edgeNumber) {
        head = new int[pointsNumber];
        next = new int[edgeNumber + 1];
        vert = new int[edgeNumber + 1];
        cost = new int[edgeNumber + 1];
    }

    public int[] getHead() {
        return head;
    }

    public int[] getNext() {
        return next;
    }

    public int[] getVert() {
        return vert;
    }

    public int[] getCost() {
        return cost;
    }

    public void add(int u, int v, int w) {
        next[cnt] = head[u];
        vert[cnt] = v;
        cost[cnt] = w;
        head[u] = cnt++;
    }
}
