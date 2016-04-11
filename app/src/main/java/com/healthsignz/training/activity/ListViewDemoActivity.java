package com.healthsignz.training.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.healthsignz.training.R;
import com.healthsignz.training.adapter.UserDetailAdapter;

public class ListViewDemoActivity extends AppCompatActivity {
    String[] labelNames;
    private ListView listViewUserDetails;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        listViewUserDetails = (ListView) findViewById(R.id.listView_user_details);
        buttonSubmit = (Button) findViewById(R.id.button_submit);
        labelNames = getResources().getStringArray(R.array.label_names);
        listViewUserDetails.setAdapter(new UserDetailAdapter(this, labelNames, listViewUserDetails));
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String s : UserDetailAdapter.validation)
                    Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
