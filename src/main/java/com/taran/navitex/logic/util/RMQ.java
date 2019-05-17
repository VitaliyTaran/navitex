package com.taran.navitex.logic.util;

import java.util.Arrays;

public class RMQ {
    private int INF = Integer.MAX_VALUE / 2;
    private int n;
    private int[] val;
    private int[] ind;

    public RMQ(int size) {
        n = size;
        val = new int[2 * n];
        ind = new int[2 * n];
        Arrays.fill(val, INF);
        for (int i = 0; i < n; i++)
            ind[n + i] = i;
    }

    public void set(int index, int value) {
        val[n + index] = value;
        for (int v = (n + index) / 2; v > 0; v /= 2) {
            int l = 2 * v;
            int r = l + 1;
            if (val[l] <= val[r]) {
                val[v] = val[l];
                ind[v] = ind[l];
            } else {
                val[v] = val[r];
                ind[v] = ind[r];
            }
        }
    }

    public int minIndex() {
        return val[1] < INF ? ind[1] : -1;
    }

}
