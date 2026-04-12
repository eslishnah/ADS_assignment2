public class Main {

    public static void main(String[] args) {

        // MyArrayList
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(3);
        list.add(1);
        list.add(5);

        list.addFirst(10);
        list.addLast(20);

        System.out.println("MyArrayList:");
        System.out.println("First element: " + list.get(0));

        list.remove(1);

        list.sort();

        for (Integer x : list) {
            System.out.println(x);
        }

        System.out.println("Size: " + list.size());



        System.out.println("-----");




        // MyLinkedList
        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        list2.add(10);
        list2.add(20);
        list2.addFirst(5);
        list2.addLast(30);

        System.out.println("MyLinkedList:");
        System.out.println("First element: " + list2.get(0));

        list2.remove(1);

        for (Integer x : list2) {
            System.out.println(x);
        }

        System.out.println("Size: " + list2.size());




        System.out.println("-----");




        // MyStack
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("MyStack:");
        System.out.println("Top: " + stack.peek());

        System.out.println("Pop: " + stack.pop());

        System.out.println("After pop:");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }



        System.out.println("-----");




        // MyQueue
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("MyQueue:");
        System.out.println("First: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());

        System.out.println("After dequeue:");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }



        System.out.println("-----");




        // MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);

        System.out.println("MyMinHeap:");
        System.out.println("Min:" + heap.peek());

        System.out.println("Size: " + heap.size());

        System.out.println("Remove: " + heap.remove());

        System.out.println("After remove:");

        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }


    }
}