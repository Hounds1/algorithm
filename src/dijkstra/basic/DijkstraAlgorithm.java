package dijkstra.basic;

import dijkstra.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 다익스트림 알고리즘은 한 정점에서 다른 모든 정점까지의 최단 경로를 찾는 알고리즘입니다.
 */
public class DijkstraAlgorithm {

    /**
     * 다익스트라 알고리즘을 실행하는 메소드입니다.
     */
    public static void dijkstra(List<List<Edge>> graph, int start) {
        int numVertices = graph.size();
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        /**
         * 각 정점의 초기 거리 값을 배열에 무한대로 설정하고,
         * 시작 정점의 거리를 0으로 초기화합니다.
         */
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        /**
         * 우선순위 큐 minHeap에 시작 정점과 거리 0을 넣습니다.
         */
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getWeight(), b.getWeight()));
        minHeap.offer(new Edge(start, 0));

        /**
         * minHeap이 비어있지 않은 동안 다음 작업을 반복합니다.
         */
        while (!minHeap.isEmpty()) {
            /**
             * minHeap에서 가장 가까운 정점('current')을 꺼내서 방문합니다.
             */
            Edge current = minHeap.poll();
            int vertex = current.getTarget();

            /**
             * 이미 방문한 경우 넘어갑니다.
             */
            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;

            /**
             * 현재 정점과 연결된 모든 이웃 정점에 대해
             * 최단 거리를 업데이트 하고 업데이트 된 거리로
             * minHeap에 넣습니다.
             */
            for (Edge neighbor : graph.get(vertex)) {
                int newDistance = distances[vertex] + neighbor.getWeight();
                if (newDistance < distances[neighbor.getTarget()]) {
                    distances[neighbor.getTarget()] = newDistance;
                    minHeap.offer(new Edge(neighbor.getTarget(), newDistance));
                }
            }
        }

        /**
         * 최단 거리 결과를 출력합니다.
         */
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " : Distance = " + distances[i]);
        }
    }

    /**
     * 그래프를 생성하고 시작 정점을 설정한 뒤 dijkstra()를 호출하여
     * 최단 경로를 구합니다.
     */
    public static void main(String[] args) {
        int numVertices = 5;
        List<List<Edge>> graph = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(2).add(new Edge(4, 3));
        graph.get(3).add(new Edge(4, 1));

        int startVertex = 0;

        dijkstra(graph, startVertex);
    }
}
