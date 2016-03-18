package com.healthsignz.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    RecyclerView colorList;
    List<ContactInfo> contactInfoList;
    TextView mTextViewCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        mTextViewCount = (TextView) findViewById(R.id.textView_item_count);
        colorList = (RecyclerView) findViewById(R.id.color_list);
        RecyclerView.LayoutManager appearence = new LinearLayoutManager(this);
        colorList.setLayoutManager(appearence);
        contactInfoList = new ArrayList();
    }

    class ContactInfo {
        String name;
        String mobileNo;
        String city;
        ContactInfo(String name, String mobileNo, String city) {
            this.name     =  name;
            this.mobileNo = mobileNo;
            this.city     =  city;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contact_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_new_contact:
                Intent newContactIntent = new Intent(getBaseContext(), NewContactActivity.class);
                startActivityForResult(newContactIntent, 1);
                break;
            case R.id.menu_edit:
                Intent editContactIntent = new Intent(getBaseContext(), NewContactActivity.class);
                editContactIntent.putExtra("edit", "contact");
                startActivityForResult(editContactIntent, 2);
                break;
            case R.id.menu_total_contact:
                mTextViewCount.setText(String.valueOf(NewContactActivity.count));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent receivedIntent) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            contactInfoList.add(new ContactInfo(receivedIntent.getStringExtra("name"), receivedIntent.getStringExtra("phone"),
                    receivedIntent.getStringExtra("city")));
            colorList.setAdapter(new ContactAdapter(contactInfoList));
        }

        if (requestCode == 2 && resultCode == RESULT_OK) {
            int itemPosition = Integer.parseInt(receivedIntent.getStringExtra("item position to edit"));
            int i = 0;
            ContactInfo editedContact = new ContactInfo(receivedIntent.getStringExtra("name"), receivedIntent.getStringExtra("phone"),
                    receivedIntent.getStringExtra("city"));
            ListIterator<ContactInfo> contactInfoIterator = contactInfoList.listIterator();
            while(contactInfoIterator.hasNext()) {
                if (i++ == itemPosition) {
                    contactInfoIterator.set(editedContact);
                    break;
                }
                contactInfoIterator.next();
            }
            colorList.setAdapter(new ContactAdapter(contactInfoList));
        }
    }
}
