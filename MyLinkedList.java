public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        MyNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        MyNode newNode = new MyNode(item);

        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    @Override
    public T get(int index) {
        MyNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void set(int index, T item) {
        MyNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = item;
    }

    @Override
    public void removeFirst() {
        if (head == null) return;

        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) return;

        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        size--;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        MyNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean exists(Object object) {

        return indexOf(object) != -1;
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;

        while (current != null) {

            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }

        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        int i = 0;

        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }

        return arr;
    }

    @Override
    public void sort() {
        if (size < 2) return;

        for (int i = 0; i < size; i++) {
            MyNode current = head;

            while (current.next != null) {
                Comparable a = (Comparable) current.data;
                Comparable b = (Comparable) current.next.data;

                if (a.compareTo(b) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }

                current = current.next;
            }
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            MyNode current = head;

            public boolean hasNext() {

                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}