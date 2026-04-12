public class MyArrayList<T> implements MyList<T> {

    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[5];
        size = 0;
    }

    private void grow() {
        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    @Override
    public void add(T item) {
        if (size == data.length) {
            grow();
        }
        data[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        data[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (size == data.length) {
            grow();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public T getFirst() {
        return (T) data[0];
    }

    @Override
    public T getLast() {
        return (T) data[size - 1];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        size--;
    }

    @Override
    public void sort() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                Comparable a = (Comparable) data[j];
                Comparable b = (Comparable) data[j + 1];

                if (a.compareTo(b) > 0) {
                    Object temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = data[i];
        }
        return arr;
    }

    @Override
    public void clear() {
        data = new Object[5];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return (T) data[index++];
            }
        };
    }
}