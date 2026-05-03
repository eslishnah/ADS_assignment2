import java.util.Iterator;
import java.util.Stack;

public class MyBST<K extends Comparable<K>, V> implements Iterable<MyBST.Entry<K, V>> {

    // node
    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // entry
    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // root + size
    private Node root;
    private int size;

    // insert
    public void insert(K key, V value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insertRec(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRec(node.right, key, value);
        } else {
            node.value = value; // update value if key exists
        }

        return node;
    }

    // search
    public V search(K key) {
        Node current = root;

        while (current != null) {
            if (key.compareTo(current.key) == 0) {
                return current.value;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // size
    public int size() {
        return size;
    }

    // in-order iterator
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {

            Stack<Node> stack = new Stack<>();
            Node current = root;

            @Override
            public boolean hasNext() {
                return current != null || !stack.isEmpty();
            }

            @Override
            public Entry<K, V> next() {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                current = stack.pop();
                Entry<K, V> result = new Entry<>(current.key, current.value);
                current = current.right;

                return result;
            }
        };
    }

    // print (optional debug)
    public void printInOrder() {
        for (Entry<K, V> e : this) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}