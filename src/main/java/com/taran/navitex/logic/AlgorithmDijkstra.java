package com.taran.navitex.logic;

import com.taran.navitex.entity.*;

import java.util.*;

public class AlgorithmDijkstra {
    private final int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
    private MultiList multiList; // описание графа
    private boolean[] used; // массив пометок
    private int[] prev; // массив предков
    private int[] dist; // массив расстояний
    private RMQ rmq; // RMQ
    private int numberOfFirstPoint;
    private int numberOfLastPoint;
    private Graph graph;


    public void execute(Graph graph, int numberOfFirstPoint, int numberOfLastPoint) {
        this.graph = graph;
        init();
        this.numberOfFirstPoint = numberOfFirstPoint;
        this.numberOfLastPoint = numberOfLastPoint;
        startAlgorithm();
    }

    public List<Point> getRecoveredPath() {
        /* Восстановление пути */
        Stack<Integer> stack = new Stack<>();
        for (int v = numberOfLastPoint; v != -1; v = prev[v]) {
            stack.push(v);
        }
        int[] recoveredPath = new int[stack.size()];
        for (int i = 0; i < recoveredPath.length; i++) {
            recoveredPath[i] = Integer.valueOf(stack.pop().toString()) + 1;
        }

        List<Point> result = new ArrayList<>();
        for (int value : recoveredPath) {
            result.add(searchPointById(graph.getPoints(), value));
        }
        return result;
    }

    public int getCost() {
        return dist[numberOfLastPoint];
    }

    private Point searchPointById(List<Point> points, int id) {
        Optional<Point> point = points.stream().filter(o -> o.getId() == id).findFirst();
        // TODO: 5/16/2019 return exception
        return point.orElse(null);
    }

    private void init() {
        List<Point> vertexes = graph.getPoints();
        List<Edge> edges = graph.getEdges();

        int numberOfVertex = vertexes.size();// количество вершин
        used = new boolean[numberOfVertex]; // массив пометок
        prev = new int[numberOfVertex]; // массив предков
        dist = new int[numberOfVertex]; // массив расстояний
        rmq = new RMQ(numberOfVertex); // RMQ

        prepareMultiList(numberOfVertex, edges);

        Arrays.fill(prev, -1);
        Arrays.fill(dist, INF);
    }

    private void prepareMultiList(int numberOfVertex, List<Edge> edges) {
        multiList = new MultiList(numberOfVertex, edges.size());
        edges.forEach(edge -> {
            Point firstPoint = edge.getFirst();
            Point secondPoint = edge.getSecond();
            multiList.add(firstPoint.getId(), secondPoint.getId(), edge.getCost());
        });
    }

    /* Алгоритм Дейкстры за O(E log V) */
    private void startAlgorithm() {
        rmq.set(numberOfFirstPoint, dist[numberOfFirstPoint] = 0);
        for (; ; ) {
            int v = rmq.minIndex(); // выбираем ближайшую вершину
            if (v == -1 || v == numberOfLastPoint) break; // если она не найдена, или является конечной, то выходим
            used[v] = true; // помечаем выбранную вершину
            rmq.set(v, INF); // и сбрасываем ее значение в RMQ
            for (int i = multiList.getHead()[v]; i != 0; i = multiList.getNext()[i]) { // проходим пр смежным вершинам
                int nv = multiList.getVert()[i];
                int cost = multiList.getCost()[i];
                if (!used[nv] && dist[nv] > dist[v] + cost) { // если можем улучшить оценку расстояния
                    rmq.set(nv, dist[nv] = dist[v] + cost); // улучшаем ее
                    prev[nv] = v; // помечаем предка
                }
            }
        }
    }
}
