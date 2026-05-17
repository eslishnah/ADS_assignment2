import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected Vertex<V> start;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected Map<Vertex<V>, Boolean> marked;

    public Search(Vertex<V> start) {
        this.start = start;
        this.edgeTo = new HashMap<>();
        this.marked = new HashMap<>();
    }

    public List<Vertex<V>> pathTo(Vertex<V> dest) {
        if (!marked.containsKey(dest)) return null;

        LinkedList<Vertex<V>> path = new LinkedList<>();
        Vertex<V> current = dest;

        while (!current.equals(start)) {
            path.addFirst(current);
            current = edgeTo.get(current);
        }

        path.addFirst(start);
        return path;
    }

    public boolean hasPathTo(Vertex<V> dest) {
        return marked.containsKey(dest);
    }
}