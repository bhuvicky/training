package com.healthsignz.training;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.LinkedList;

/**
 * Created by Lenovo on 14/03/2016.
 */
public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;
    MainActivity context;

    public MyLinkedList(MainActivity context) {
        this.context = context;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(Object element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        size++;
        Log.d("link", "adding to First "+ element);
    }

    public void addLast(Object element) {
        Node tmp = new Node(element, null, tail);
        if (tail != null)
            tail.next = tmp;
        tail = tmp;
        size++;
        Log.d("link", "adding to Last "+ element);
    }

    public void addAtPosition(Object element, int position) {

            Node node = new Node(element,null,null);
            if(position==0){
                addFirst(element);
                return ;
            }
        Node tmp = head;
            for(int i=1 ;i <= size ; i++){
                if(i==position){

                    Node temp = tmp.next;
                    ptr.setNext(node);
                    node.setPrev(ptr);
                    node.setNext(temp);
                    temp.setPrev(node);
                }
                ptr = ptr.getNext();
            }
            size++;

        /*if (position != 1 && position <= getSize()) {
            for(int i = 2; i < position; i++)
                tmp = tmp.next;
        }
        Node newTemp = new Node(element, tmp.next, tmp);
        tmp.next = newTemp;
        newTemp.next.prev = newTemp;*/
        size++;
        Log.d("link", "adding "+ element + " at position" + position);
    }

    public void removeFirst() {
        head = head.next;
        if(head != null)
            head.prev = null;
        size--;
    }

    public void removeLast() {
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        else
            head = null;
        size--;
    }

    public  void removeAtPosition(int position) {
        Node temp = head;
        for(int i = 1; i < position; i++) {
            temp = temp.next;
        }
        if(temp != head && temp != tail) {
            temp.prev.next  = temp.next;
            temp.next.prev  = temp.prev;
            size--;
        }
        else
            Toast.makeText(context, "only elements in between first and last can be removed", Toast.LENGTH_SHORT).show();

    }

    public void print(){

        StringBuilder print = new StringBuilder();
        /*if(head==null){
            print.append("nothing");
            context.textViewResult.setText(String.valueOf(print));
            return;
        }

        if(head.next==null){
            print.append(head.element);
            context.textViewResult.setText(String.valueOf(print));
            return;
        }*/

        Node tmp = head;
        print.append(tmp.element).append(" - ");
        context.textViewResult.setText(String.valueOf(print));
        Node tmp2 = tmp.next ;
        while(tmp2.next != null) {
           // Log.d("link", "Result " + tmp.element);
            print.append(tmp2.element).append(" - ");
            tmp2 = tmp2.next;
        }
        print.append(tmp2.element);
        context.textViewResult.setText(String.valueOf(print));
    }
}
