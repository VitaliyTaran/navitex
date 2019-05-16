package com.taran.navitex.logic;

import com.taran.navitex.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AlgorithmDijkstra {
    private final int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
    private MultiList multiList; // описание графа
    private boolean[] used; // массив пометок
    private int[] prev; // массив предков
    private int[] dist; // массив расстояний
    private RMQ rmq; // RMQ

    private void init(Graph graph) {
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

    /* Алгоритм Дейкстры за O(E log V) */
    public void execute(Graph graph, int start, int end) {
        init(graph);
        rmq.set(start, dist[start] = 0);
        for (; ; ) {
            int v = rmq.minIndex(); // выбираем ближайшую вершину
            if (v == -1 || v == end) break; // если она не найдена, или является конечной, то выходим
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

        /* Вывод результата */
        printResult(start, end, dist);
        printRecoveredPath(end);

    }

    private MultiList prepareMultiList(int numberOfVertex, List<Edge> edges) {
        multiList = new MultiList(numberOfVertex, edges.size());
        edges.forEach(edge -> {
            Point firstPoint = edge.getFirst();
            Point secondPoint = edge.getSecond();
            multiList.add(firstPoint.getId(), secondPoint.getId(), edge.getCost());
        });
        return multiList;
    }

    private int[] makePath(int end) {
        /* Восстановление пути */
        Stack<Integer> stack = new Stack<>();
        for (int v = end; v != -1; v = prev[v]) {
            stack.push(v);
        }
        int[] recoveredPath = new int[stack.size()];
        for (int i = 0; i < recoveredPath.length; i++) {
            recoveredPath[i] = Integer.valueOf(stack.pop().toString()) + 1;
        }
        return recoveredPath;
    }

    private void printRecoveredPath(int end) {
        System.out.println("Кратчайший путь: " + Arrays.toString(makePath(end)));
    }

    private void printResult(int start, int end, int[] dist) {
        System.out.printf("Кратчайшее расстояние между %d и %d = %d%n", start + 1, end + 1, dist[end]);
    }

}
