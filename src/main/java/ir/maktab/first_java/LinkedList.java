package ir.maktab.first_java;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head, tail = null;
    private int size = 0;

    boolean isEmpty() {
        return Objects.isNull(head);
    }

    T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            if (index <= Math.floor(size / 2.0))
                return getStartFromHead(index);
            else
                return getStartFromTail(index);
        }
    }

    private T getStartFromTail(int index) {
        Node<T> endNode = tail;
        int counter = size - 1;
        while (counter != index) {
            endNode = endNode.previous;
            counter--;
        }
        return endNode.data;
    }

    private T getStartFromHead(int index) {
        Node<T> startNode = head;
        int counter = 0;
        while (counter != index) {
            startNode = startNode.next;
            counter++;
        }
        return startNode.data;
    }

    void set(int index, T data) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            if (index <= Math.floor(size / 2.0))
                setStartFromHead(index, data);
            else
                setStartFromTail(index, data);

        }
    }

    private void setStartFromTail(int index, T data) {
        Node<T> addNode = new Node<>(data);
        Node<T> endNode = tail;
        if (index == size) {
            tail.next = addNode;
            addNode.previous = tail;
            addNode.next = null;
            tail = addNode;
        } else {
            int counter = size - 1;
            while (counter != index) {
                endNode = endNode.previous;
                counter--;
            }
            addNode(addNode, endNode);
        }
        size++;
    }

    private void setStartFromHead(int index, T data) {
        Node<T> addNode = new Node<>(data);
        Node<T> startNode = head;
        if (index == 0) {
            head.previous = addNode;
            addNode.next = head;
            addNode.previous = null;
            head = addNode;
        } else {
            int counter = 0;
            while (counter != index) {
                startNode = startNode.next;
                counter++;
            }
            addNode(addNode, startNode);
        }
        size++;
    }

    private void addNode(Node<T> addNode, Node<T> nextNode) {
        Node<T> previousNode = nextNode.previous;
        previousNode.next = addNode;
        addNode.previous = previousNode;
        addNode.next = nextNode;
        nextNode.previous = addNode;
    }

    void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        tail = node;
        size++;
    }

    T poll() {
        Node<T> node = head;
        if (node.equals(tail)) {
            tail = null;
            head = null;
        } else {
            node = tail;
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return node.data;
    }

    int size() {
        return size;
    }

    boolean contain(T data) {
        Node<T> startNode = head;
        Node<T> endNode = tail;
        int step = 0;
        while (step != Math.ceil(size / 2.0)) {
            if (startNode.data.equals(data)) return true;
            else if (endNode.data.equals(data)) return true;
            else {
                startNode = startNode.next;
                endNode = endNode.previous;
                step++;
            }
        }
        return false;
    }

    int indexOf(T data) {
        Node<T> startNode = head;
        Node<T> endNode = tail;
        int startStep = 0;
        int endStep = size - 1;
        while (startStep != Math.ceil(size / 2.0)) {
            if (startNode.data.equals(data)) return startStep;
            else if (endNode.data.equals(data)) return endStep;
            else {
                startNode = startNode.next;
                endNode = endNode.previous;
                startStep++;
                endStep--;
            }
        }
        return -1;
    }

}
