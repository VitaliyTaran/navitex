package com.taran.navitex.logic;

import com.taran.navitex.entity.Edge;
import com.taran.navitex.entity.Graph;
import com.taran.navitex.entity.Sensor;
import com.taran.navitex.entity.TypeAlgorithm;
import com.taran.navitex.exception.NavitexLogicAlgorithmException;
import com.taran.navitex.logic.util.MultiList;
import com.taran.navitex.logic.util.RMQ;

import java.util.*;

public class AlgorithmDijkstra {
    private static final String SEARCHING_POINT_BY_ID_EXCEPTION_MESSAGE = "Point hasn't found into graph pointId = ";
    private final int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
    private MultiList multiList; // описание графа
    private boolean[] used; // массив пометок
    private int[] prev; // массив предков
    private int[] dist; // массив расстояний
    private RMQ rmq; // RMQ
    private int numberOfFirstPoint;//номер первой вершины
    private int numberOfLastPoint;//номер последней вершины
    private Graph graph; //Граф точек и ребер
    private TypeAlgorithm type;

    public AlgorithmDijkstra(TypeAlgorithm type) {
        this.type = type;
    }

    public void execute(Graph graph, Sensor first, Sensor second) {
        this.graph = graph;
        this.numberOfFirstPoint = first.getId();
        this.numberOfLastPoint = second.getId();

        List<Sensor> vertexes = graph.getSensors();
        List<Edge> edges = graph.getEdges();

        int numberOfVertex = vertexes.size();// количество вершин
        used = new boolean[numberOfVertex]; // массив пометок
        prev = new int[numberOfVertex]; // массив предков
        dist = new int[numberOfVertex]; // массив расстояний
        rmq = new RMQ(numberOfVertex); // RMQ

        prepareMultiList(numberOfVertex, edges);

        Arrays.fill(prev, -1);
        Arrays.fill(dist, INF);
        startAlgorithm();
    }

    public List<Sensor> calculatePath() throws NavitexLogicAlgorithmException {
        Stack<Integer> stack = new Stack<>();
        for (int v = numberOfLastPoint; v != -1; v = prev[v]) {
            stack.push(v);
        }
        int[] recoveredPath = new int[stack.size()];
        for (int i = 0; i < recoveredPath.length; i++) {
            recoveredPath[i] = Integer.valueOf(stack.pop().toString());
        }

        List<Sensor> result = new ArrayList<>();
        for (int value : recoveredPath) {
            result.add(searchPointById(graph.getSensors(), value));
        }
        return result;
    }

    public int calculateCost() {
        return dist[numberOfLastPoint];
    }

    private Sensor searchPointById(List<Sensor> points, int id) throws NavitexLogicAlgorithmException {
        Optional<Sensor> point = points.stream().filter(o -> o.getId() == id).findFirst();
        if (point.isPresent()) {
            return point.get();
        } else {
            throw new NavitexLogicAlgorithmException(SEARCHING_POINT_BY_ID_EXCEPTION_MESSAGE + id);
        }
    }

    private void prepareMultiList(int numberOfVertex, List<Edge> edges) {
        multiList = new MultiList(numberOfVertex, edges.size());
        switch (type) {
            case BY_COST:
                edges.forEach(edge -> {
                    Sensor firstPoint = edge.getFirst();
                    Sensor secondPoint = edge.getSecond();
                    multiList.add(firstPoint.getId(), secondPoint.getId(), edge.getCost());
                });
                break;
            case BY_DISTANCE:
                edges.forEach(edge -> {
                    Sensor firstPoint = edge.getFirst();
                    Sensor secondPoint = edge.getSecond();
                    multiList.add(firstPoint.getId(), secondPoint.getId(), (int) edge.getDistance());
                });
                break;
            case BY_MARK:
                edges.forEach(edge -> {
                    Sensor firstPoint = edge.getFirst();
                    Sensor secondPoint = edge.getSecond();
                    multiList.add(firstPoint.getId(), secondPoint.getId(), (int) edge.getAverageMark());
                });
                break;
        }
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
