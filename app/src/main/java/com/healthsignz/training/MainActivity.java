package com.healthsignz.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText editTextEnterData, editTextEnterPosition;
    TextView textViewResult;
    MyLinkedList link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEnterData = (EditText) findViewById(R.id.editText_data);
        editTextEnterPosition = (EditText) findViewById(R.id.editText_position);
        textViewResult = (TextView) findViewById(R.id.textView_Result);

        MyArrayList arrayList = new MyArrayList();
        Log.d("arraylist", "size = " + arrayList.size());
        arrayList.add("Red");
        arrayList.add("Green");
        arrayList.add("Blue");
        arrayList.add("Violet");
        arrayList.add("Black");
        arrayList.add("Red");
        arrayList.add("Green");
        arrayList.add("Blue");
        arrayList.add("Violet");
        arrayList.add("Black");
        Log.d("arraylist", "size = " + arrayList.size());
        Log.d("arraylist", " " + arrayList.toString());
        arrayList.remove(1);
        Log.d("arraylist", "after removed object in first index " + arrayList.toString());

        link = new MyLinkedList(this);
        /*link.addFirst(10);
        link.print();
        link.addFirst(30);
        link.print();
        link.addLast(3);
        link.print();
        link.addLast("seven");
        link.addLast(13);
        link.addLast(29);
        link.addAtPosition(90, 2);
        link.removeFirst();
        link.removeLast();
        link.removeElement(3);*/
        /*link.print();*/
        Log.d("link", "size = " + link.getSize());
    }

    public void addAtFirst(View view) {
        link.addFirst(editTextEnterData.getText().toString());
        link.print();
    }

    public void addAtLast(View view) {
        link.addLast(editTextEnterData.getText().toString());
        link.print();
    }

    public void addAtPosition(View view) {
        link.addAtPosition(editTextEnterData.getText(), Integer.parseInt(editTextEnterPosition.getText().toString()));
        link.print();
    }

    public void removeAtFirst(View view) {
        if (link.getSize() != 0) {
            link.removeFirst();
            link.print();
        }
        else
            Toast.makeText(getBaseContext(), "All elements were removed, nothing there to remove", Toast.LENGTH_SHORT).show();

    }

    public void removeAtLast(View view) {
        if (link.getSize() != 0) {
            link.removeLast();
            link.print();
        }
        else
            Toast.makeText(getBaseContext(), "All elements were removed, nothing there to remove", Toast.LENGTH_SHORT).show();
    }

    public void removeAtPosition(View view) {
        if (link.getSize() != 0) {
            link.removeAtPosition(Integer.parseInt(editTextEnterPosition.getText().toString()));
            link.print();
        }
        else
            Toast.makeText(getBaseContext(), "All elements were removed, nothing there to remove", Toast.LENGTH_SHORT).show();
    }
}
