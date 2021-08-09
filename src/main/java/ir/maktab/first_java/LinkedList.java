package ir.maktab.first_java;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head, tail = null;
    private int size = 0;
    private int capacity = 10;

    boolean isEmpty() {
        return Objects.isNull(head);
    }

    T get(int index) {
        return null;
    }

    void set(int index, T data) {

    }

    void add(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            head = tail = node;
            head.privious = null;
            tail.next = null;
        } else {
            tail.next = node;
            node.privious = tail;
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
            size--;
            return node.data;
        } else {
            node = tail;
            tail = tail.privious;
            tail.next = null;
            size--;
            return node.data;
        }
    }

    int size() {
        return size;
    }

    boolean contain(T data) {
        Node<T> startNode = head;
        Node<T> endNode = tail;
        int step = 0;
        while(step != Math.ceil(size / 2.0)) {
            if(startNode.data.equals(data)) return true;
            else if (endNode.data.equals(data)) return true;
            else {
                startNode = startNode.next;
                endNode = endNode.privious;
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
        while(startStep != Math.ceil(size / 2.0)) {
            if(startNode.data.equals(data)) return startStep;
            else if (endNode.data.equals(data)) return endStep;
            else {
                startNode = startNode.next;
                endNode = endNode.privious;
                startStep++;
                endStep--;
            }
        }
        return -1;
    }

}
