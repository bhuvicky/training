package com.healthsignz.training.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.healthsignz.training.R;
import com.healthsignz.training.adapter.UserDetailAdapter;

public class ListViewDemoActivity extends AppCompatActivity {
    String[] labelNames;
    private ListView listViewUserDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        listViewUserDetails = (ListView) findViewById(R.id.listView_user_details);
        labelNames = getResources().getStringArray(R.array.label_names);
        listViewUserDetails.setAdapter(new UserDetailAdapter(this, labelNames));
    }
}
