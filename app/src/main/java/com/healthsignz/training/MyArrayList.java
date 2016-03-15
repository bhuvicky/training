package com.healthsignz.training;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Lenovo on 11/03/2016.
 */
public class MyArrayList {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    Object[] array, newArray;
    int noOfElements, index, newCapacity, oldCapacity;

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        for(int i = 0; i < noOfElements; i++)
            print.append(array[i].toString()).append(",");
        return  "[" + print + "]";
    }
    MyArrayList() {
        array = new Object[DEFAULT_INITIAL_CAPACITY];
        oldCapacity = DEFAULT_INITIAL_CAPACITY;
    }

    MyArrayList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("size given is less than 0");
        array = new Object[capacity];
    }

    public boolean add(Object element) {
        if (size() == oldCapacity) {
            Log.d("arraylist", "arraylist full");
            newCapacity = (oldCapacity * 3/2)+1;
            Log.d("arraylist", "new capacity = "+ newCapacity);
            newArray = new Object[newCapacity];
            newArray = Arrays.copyOf(array, array.length);
            array = newArray;
            Log.d("arraylist", "new array content" + Arrays.toString(array));
            oldCapacity = newCapacity;
        }
        array[index++] = element;
        return true;
    }

    public int size() {
        noOfElements = 0;
        for(Object element: array) {
            if (element == null)
                break;
            else
                noOfElements++;
        }
        return noOfElements;
    }

    public void remove(int index) {
        if(index < 0 || index > size()-1)
            throw new IndexOutOfBoundsException("Given index is not in the range");
        Log.d("arraylist", " " + size());
        for (int i = index; i < size()-1; i++)
                array[i] = array[i+1];
        noOfElements--;
        Log.d("arraylist", " " + array.toString());
    }
}
