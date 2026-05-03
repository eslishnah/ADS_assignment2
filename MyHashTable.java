public class MyHashTable<K, V> {

    // node
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // fields
    private HashNode<K, V>[] table;
    private int M = 11;
    private int size;

    // constr
    public MyHashTable() {
        table = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        table = new HashNode[M];
    }

    // hash function
    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % M;
    }

    // put
    public void put(K key, V value) {
        int index = hash(key);

        remove(key);

        HashNode<K, V> node = new HashNode<>(key, value);

        if (table[index] == null) {
            table[index] = node;
        } else {
            HashNode<K, V> current = table[index];

            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        size++;
    }

    // get
    public V get(K key) {
        int index = hash(key);

        HashNode<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    // remove
    public V remove(K key) {
        int index = hash(key);

        HashNode<K, V> current = table[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {

                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                return current.value;
            }

            prev = current;
            current = current.next;
        }

        return null;
    }

    // contains value
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = table[i];

            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    // get key by value
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = table[i];

            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

    // size
    public int size() {
        return size;
    }

    // optionak debug
    public void printTable() {
        for (int i = 0; i < M; i++) {
            System.out.print(i + ": ");
            HashNode<K, V> current = table[i];

            while (current != null) {
                System.out.print("{" + current.key + "=" + current.value + "} -> ");
                current = current.next;
            }

            System.out.println("null");
        }
    }
}