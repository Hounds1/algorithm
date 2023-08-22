package search.dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

    private int V;
    private LinkedList<Integer>[] adj;

    /**
     * 인접 리스트 초기화 생성자
     */
    DFSGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * node를 연결
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    /**
     * 실제 사용되는 함수
     */
    void DFSUtil(int v, boolean[] visited) {
        //현재 노드 방문 표시 및 값 출력
        visited[v] = true;
        System.out.println(v + " ");

        // 방문한 노드와 인접 노드를 모두 가져옴
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();

            // 방문하지 않았다면 해당 노드를 시작 노드로 재귀 호출
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    /**
     * 시작 노드 값이 주어진 경우
     */
    void scan(int v) {
        boolean[] visited = new boolean[V];

        DFSUtil(v, visited);
    }

    // 비연결형 그래프의 경우
    void scan() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; ++i) {
            if (!visited[i])
                DFSUtil(i, visited);
        }
    }
}
