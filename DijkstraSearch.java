import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(start);
        distTo = new HashMap<>();
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph<V> graph, Vertex<V> start) {
        for (Vertex<V> v : graph.getVertices().keySet()) {
            distTo.put(v, Double.MAX_VALUE);
        }
        distTo.put(start, 0.0);

        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(distTo.get(a), distTo.get(b))
        );
        pq.add(start);
        marked.put(start, true);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDist = distTo.get(current) + weight;

                if (newDist < distTo.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    marked.put(neighbor, true);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double distanceTo(Vertex<V> dest) {
        return distTo.getOrDefault(dest, Double.MAX_VALUE);
    }
}