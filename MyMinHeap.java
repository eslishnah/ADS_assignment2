public class MyMinHeap<T extends Comparable<T>> {

    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void add(T item) {
        list.add(item);
        heapifyUp();
    }

    public T remove() {
        if (isEmpty()) return null;

        T min = list.get(0);

        list.set(0, list.getLast());
        list.removeLast();

        heapifyDown();

        return min;
    }

    public T peek() {
        if (isEmpty()) return null;
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp() {
        int index = list.size() - 1;

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (list.get(index).compareTo(list.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < list.size() &&
                    list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < list.size() &&
                    list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}