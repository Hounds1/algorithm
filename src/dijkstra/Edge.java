package dijkstra;

/**
 * 그래프의 간선을 나타내기 위한 클래스입니다.
 * 각 간선은 목표 정점인 target, 가중치인 weight를 가집니다.
 */
public class Edge {

    int target;
    int weight;

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
