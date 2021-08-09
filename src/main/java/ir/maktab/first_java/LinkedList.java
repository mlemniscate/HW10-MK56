package ir.maktab.first_java;

import java.util.Objects;

public class LinkedList<T>{
    private Node<T> head, tail = null;
    private int size;

    boolean isEmpty() {
        return Objects.isNull(head);
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
    }

     T delete() {
        Node<T> previousNode = head;
        if (previousNode.equals(tail)) {
            tail = null;
            head = null;
            return previousNode.data;
        } else {
            while (!previousNode.next.equals(tail)) {
                previousNode = previousNode.next;
            }
        }
        tail = previousNode;
        return previousNode.next.data;
    }

    boolean contain(T data) {
        Node<T> node = head;
        do {
            if(node.data.equals(data)) return true;
            else node = node.next;
        } while (!Objects.isNull(node));
        return false;
    }

    int indexOf(T data) {
        Node<T> node = head;
        int counter = 0;
        do {
            if(node.data.equals(data)) return counter;
            else {
                node = node.next;
                counter++;
            }
        } while (!Objects.isNull(node));
        return -1;
    }

}
