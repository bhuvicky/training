package com.healthsignz.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    String[] title = {"contact1", "contact2", "contact3", "contact4", "contact5", "contact6", "contact7"};
    String[] name = {"Ram", "Hari", "Vino", "Anitha", "Krish", "Abi", "Anbu"};
    String[] mobileNo = {"9872376190", "9672347610", "8627012793", "8627012793", "8627012793", "8627012793", "8627012793"};

    Button mButtonAddRow;
    RecyclerView colorList;
    ArrayList<ContactInfo> dataSet;
    static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        
        colorList = (RecyclerView) findViewById(R.id.color_list);
        mButtonAddRow = (Button) findViewById(R.id.button_add_row);
        RecyclerView.LayoutManager appearence = new LinearLayoutManager(this);
        colorList.setLayoutManager(appearence);
         dataSet = new ArrayList();
        mButtonAddRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < title.length) {
                    dataSet.add(new ContactInfo(position));
                    colorList.setAdapter(new ContactAdapter(dataSet));
                    position++;
                }
            }
        });

    }

    class ContactInfo {
         String t;
         String n;
         String mobNo;
         ContactInfo(int position) {
             t = title[position];
             n = name[position];
             mobNo = mobileNo[position];
         }
    }

}
