package com.healthsignz.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    String[] title = {"contact1", "contact2", "contact3"};
    String[] name = {"Ram", "Hari", "Vino"};
    String[] mobileNo = {"9872376190", "9672347610", "8627012793"};
    RecyclerView colorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        colorList = (RecyclerView) findViewById(R.id.color_list);
        RecyclerView.LayoutManager appearence = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        colorList.setLayoutManager(appearence);
        colorList.setAdapter(new ContactAdapter(title, name, mobileNo));
    }
}
