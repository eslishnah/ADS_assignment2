import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, Boolean> vertices;
    private boolean undirected;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.put(vertex, true);
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        // Make sure both vertices are in the graph
        vertices.put(source, true);
        vertices.put(dest, true);

        source.addAdjacentVertex(dest, weight);

        if (undirected) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Map<Vertex<V>, Boolean> getVertices() {
        return vertices;
    }

    public boolean isUndirected() {
        return undirected;
    }
}