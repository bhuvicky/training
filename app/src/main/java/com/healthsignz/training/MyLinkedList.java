package com.healthsignz.training;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by Lenovo on 16/03/2016.
 */
public class MyLinkedList {


        private Node head;
        private Node tail;
        private int size;
        static String print="";
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
            Log.d("link", "adding to First " + element);
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

       /* Node tmp = head;*/
            Node nptr = new Node(element,null,null);
            if(position==0){
                addFirst(element);
                return ;
            }
            Node ptr = head;
            for(int i=1 ;i <= size ; i++){
                if(i==position){
                    Log.d("link", "before "+ptr.element);
                    /*Node temp = tmp.next;
                    ptr.setNext(node);
                    node.setPrev(ptr);
                    node.setNext(temp);
                temp.setPrev(node);*/
              /*  Node temp = ptr.next;
                ptr.next = nptr;
                nptr.prev = ptr;
                nptr.next = temp;
                temp.prev = nptr;*/
                    Node temp = ptr.next;
                    temp.prev = nptr;
                    nptr.next = temp ;
                    nptr.prev = ptr;
                    ptr.next = nptr;
                    Log.d("link", "after "+ptr.next.element);
                    Log.d("link", "after the new element "+nptr.next.element);
                }
                ptr = ptr.next;
            }
            size++;

        /*if (position != 1 && position <= getSize()) {
            for(int i = 2; i < position; i++)
                tmp = tmp.next;
        }
        Node newTemp = new Node(element, tmp.next, tmp);
        tmp.next = newTemp;
        newTemp.next.prev = newTemp;
        size++;*/
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

            if(getSize() == 0){
                print = "nothing";
                context.textViewResult.setText(print);
                return;
            }

            if(head.next==null){
           /* print.append(head.element);*/
                print = (String) head.element;
                context.textViewResult.setText(print);
                return;
            }



            Node tmp = head;
       /* print.append(tmp.element).append(" - ");*/
            print = tmp.element+"" + " - ";
            context.textViewResult.setText(print);
            tmp = head.next;
            while(tmp.next != null) {
                // Log.d("link", "Result " + tmp.element);
            /*print.append(tmp.element).append(" - ");*/
                print = print + tmp.element + ""+ " - ";
                tmp = tmp.next;
            }
       /* print.append(tmp.element);*/
            print = print + tmp.element + "";
            context.textViewResult.setText(print);
        }
    }

