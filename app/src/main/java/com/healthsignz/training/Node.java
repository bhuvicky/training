package com.healthsignz.training;

/**
 * Created by Lenovo on 14/03/2016.
 */
public class Node {
    Object element;
    Node next;
    Node prev;

    public Node(Object element, Node next, Node prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
}
