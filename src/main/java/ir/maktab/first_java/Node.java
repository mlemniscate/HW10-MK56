package ir.maktab.first_java;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> privious;


    public Node(T data) {
        this.data = data;
    }
}
