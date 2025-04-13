import java.util.Iterator;

class MyNode<T> {
    T data;
    MyNode<T> next;
    MyNode<T> prev;

    MyNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T item) {
        addLast(item);
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode<T> current = getNode(index);
            MyNode<T> newNode = new MyNode<>(item);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void set(int index, T item) {
        MyNode<T> node = getNode(index);
        node.data = item;
    }

    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T getFirst() {
        if (size == 0) throw new MyNoSuchElementException();
        return head.data;
    }

    public T getLast() {
        if (size == 0) throw new MyNoSuchElementException();
        return tail.data;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode<T> node = getNode(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    public void removeFirst() {
        if (size == 0) throw new MyNoSuchElementException();
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (size == 0) throw new MyNoSuchElementException();
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    public void sort() {
        if (size <= 1) return;
        Object[] array = toArray();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        clear();
        for (Object obj : array) {
            add((T) obj);
        }
    }

    public int indexOf(Object object) {
        int index = 0;
        MyNode<T> current = head;
        while (current != null) {
            if (object == null && current.data == null) return index;
            if (object != null && object.equals(current.data)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int index = size - 1;
        MyNode<T> current = tail;
        while (current != null) {
            if (object == null && current.data == null) return index;
            if (object != null && object.equals(current.data)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) throw new MyNoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}