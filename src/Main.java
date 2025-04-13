public class Main {
    public static void main(String[] args) {
        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(2);
        System.out.println("ArrayList: " + arrayList.size() + " elements");
        arrayList.sort();
        System.out.println("Sorted ArrayList: " + arrayList.get(0) + ", " + arrayList.get(1) + ", " + arrayList.get(2));
        arrayList.remove(1);
        System.out.println("After removing index 1: " + arrayList.get(0) + ", " + arrayList.get(1));

        System.out.println("\nTesting MyLinkedList:");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(2);
        System.out.println("LinkedList: " + linkedList.size() + " elements");
        linkedList.sort();
        System.out.println("Sorted LinkedList: " + linkedList.get(0) + ", " + linkedList.get(1) + ", " + linkedList.get(2));
        linkedList.remove(1);
        System.out.println("After removing index 1: " + linkedList.get(0) + ", " + linkedList.get(1));

        System.out.println("\nTesting MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        System.out.println("\nTesting MyQueue:");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        System.out.println("\nTesting MyMinHeap:");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);
        System.out.println("Heap min: " + heap.extractMin());
        System.out.println("Heap peek: " + heap.peek());
        System.out.println("Heap size: " + heap.size());
    }
}