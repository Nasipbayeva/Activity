package Activity;

public class MyLinkedList<E> extends MyAbstractList<E> {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("America");
        System.out.println("(1) " + list);
        list.add(0, "Canada");
        System.out.println("(2) " + list);
        list.add("Russia");
        System.out.println("(3) " + list);
        list.addLast("France");
        System.out.println("(4) " + list);
        list.add(2, "Germany");
        System.out.println("(5) " + list);
        list.add(5, "Norway");
        System.out.println("(6) " + list);
        list.add(0, "Poland");
        System.out.println("(7) " + list);
        list.remove(0);
        System.out.println("(8) " + list);
        list.remove(2);
        System.out.println("(9) " + list);
        list.remove(list.size() - 1);
        System.out.print("(10) " + list + "\n(11) ");
        System.out.println(list.contains("France"));
        for (String s: list)
            System.out.print(s.toUpperCase() + " ");
        list.clear();
        System.out.println("\nAfter clearing the list, the list size is " + list.size());
    }
    private Node<E> head, tail;
    public MyLinkedList() {
    }
    public MyLinkedList(E[] objects) {
        super(objects);
    }
    public E getFirst() {
        if (size == 0) {
            return null;
        }else {
            return head.element;
        }
    }
    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null)
            tail = head;
    }public void addLast(E e) {
        Node<E> newNode = new Node<E>(e);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }
    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }public E removeFirst() {
        if (size == 0) {
            return null;
        }else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }public E removeLast() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }@Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }
            else {
                result.append("]");
            }
        }
        return result.toString();
    }@Override
    public void clear() {
        size = 0;
        head = tail = null;
    }@Override
    public boolean contains(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }
    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index)
                return current.element;
            current = current.next;
        }
        return null;
    }@Override
    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                return i;
            current = current.next;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                lastIndex = i;
            current = current.next;
        }
        return lastIndex;
    }
    @Override
    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        E oldValue = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                oldValue = current.element;
                current.element = e;
                break;
            }
            current = current.next;
        }
        return oldValue;
    }
    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
    }private class LinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current = head;
        @Override
        public boolean hasNext() {
            return (current != null);
        }
        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }
        @Override
        public void remove() {
            System.out.println("Implementation left as an exercise");
        }
    }private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
}

