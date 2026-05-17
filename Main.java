//public class Main {
//
//    public static void main(String[] args) {
//
//        // MyArrayList
//        MyArrayList<Integer> list = new MyArrayList<>();
//
//        list.add(3);
//        list.add(1);
//        list.add(5);
//
//        list.addFirst(10);
//        list.addLast(20);
//
//        System.out.println("MyArrayList:");
//        System.out.println("First element: " + list.get(0));
//
//        list.remove(1);
//
//        list.sort();
//
//        for (Integer x : list) {
//            System.out.println(x);
//        }
//
//        System.out.println("Size: " + list.size());
//
//
//
//        System.out.println("-----");
//
//
//
//
//        // MyLinkedList
//        MyLinkedList<Integer> list2 = new MyLinkedList<>();
//
//        list2.add(10);
//        list2.add(20);
//        list2.addFirst(5);
//        list2.addLast(30);
//
//        System.out.println("MyLinkedList:");
//        System.out.println("First element: " + list2.get(0));
//
//        list2.remove(1);
//
//        for (Integer x : list2) {
//            System.out.println(x);
//        }
//
//        System.out.println("Size: " + list2.size());
//
//
//
//
//        System.out.println("-----");
//
//
//
//
//        // MyStack
//        MyStack<Integer> stack = new MyStack<>();
//
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//
//        System.out.println("MyStack:");
//        System.out.println("Top: " + stack.peek());
//
//        System.out.println("Pop: " + stack.pop());
//
//        System.out.println("After pop:");
//
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
//
//
//
//        System.out.println("-----");
//
//
//
//
//        // MyQueue
//        MyQueue<Integer> queue = new MyQueue<>();
//
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//
//        System.out.println("MyQueue:");
//        System.out.println("First: " + queue.peek());
//
//        System.out.println("Dequeue: " + queue.dequeue());
//
//        System.out.println("After dequeue:");
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.dequeue());
//        }
//
//
//
//        System.out.println("-----");
//
//
//
//
//        // MyMinHeap
//        MyMinHeap<Integer> heap = new MyMinHeap<>();
//
//        heap.add(5);
//        heap.add(3);
//        heap.add(8);
//        heap.add(1);
//
//        System.out.println("MyMinHeap:");
//        System.out.println("Min:" + heap.peek());
//
//        System.out.println("Size: " + heap.size());
//
//        System.out.println("Remove: " + heap.remove());
//
//        System.out.println("After remove:");
//
//        while (!heap.isEmpty()) {
//            System.out.println(heap.remove());
//        }
//
//
//
//
//
//
//        // Hash Table
//        System.out.println("MyHashTable TEST :");
//
//        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
//
//        for (int i = 0; i < 10000; i++) {
//            table.put(new MyTestingClass(i, "name" + i), i);
//        }
//
//        System.out.println("Inserted 10000 elements");
//
//        // test get
//        MyTestingClass testKey = new MyTestingClass(5, "name5");
//        System.out.println("Get test value: " + table.get(testKey));
//
//        System.out.println("Contains value 5: " + table.contains(5));
//
//        System.out.println("GetKey test: " + table.getKey(5));
//
//
//    }
//}



// Assignment 4 graphs

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- Create vertices ---
        Vertex<String> almaty    = new Vertex<>("Almaty");
        Vertex<String> astana    = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> aktobe   = new Vertex<>("Aktobe");
        Vertex<String> atyrau   = new Vertex<>("Atyrau");

        // --- Build weighted undirected graph ---
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge(almaty,    astana,    1200.0);
        graph.addEdge(almaty,    shymkent,   700.0);
        graph.addEdge(astana,    aktobe,     900.0);
        graph.addEdge(shymkent,  aktobe,    1500.0);
        graph.addEdge(aktobe,    atyrau,     600.0);
        graph.addEdge(atyrau,    astana,    1800.0);

        // ========== BFS ==========
        System.out.println("=== BFS from Almaty ===");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, almaty);

        List<Vertex<String>> bfsPath = bfs.pathTo(atyrau);
        if (bfsPath != null) {
            System.out.print("Path to Atyrau: ");
            for (Vertex<String> v : bfsPath) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("No path found.");
        }

        // ========== Dijkstra ==========
        System.out.println("\n=== Dijkstra from Almaty ===");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, almaty);

        List<Vertex<String>> dijkstraPath = dijkstra.pathTo(atyrau);
        if (dijkstraPath != null) {
            System.out.print("Shortest path to Atyrau: ");
            for (Vertex<String> v : dijkstraPath) {
                System.out.print(v + " ");
            }
            System.out.println();
            System.out.println("Total distance: " + dijkstra.distanceTo(atyrau) + " km");
        } else {
            System.out.println("No path found.");
        }

        // Check path to all vertices
        System.out.println("\n--- Distances from Almaty (Dijkstra) ---");
        for (Vertex<String> v : graph.getVertices().keySet()) {
            double dist = dijkstra.distanceTo(v);
            System.out.println(v + ": " + (dist == Double.MAX_VALUE ? "unreachable" : dist + " km"));
        }
    }
}