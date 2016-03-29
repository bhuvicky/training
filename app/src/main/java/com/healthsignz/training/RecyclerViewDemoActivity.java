package com.healthsignz.training;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    ImageButton mImageButtonAddContact;
    EditText mEditTextName, mEditTextMobileNo, mEditTextCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        mEditTextName     = (EditText) findViewById(R.id.editText_name);
        mEditTextMobileNo = (EditText) findViewById(R.id.editText_phone);
        mEditTextCity     = (EditText) findViewById(R.id.editText_city);
        mImageButtonAddContact = (ImageButton) findViewById(R.id.imageButton_add_contact);
        colorList = (RecyclerView) findViewById(R.id.color_list);
        RecyclerView.LayoutManager appearence = new LinearLayoutManager(this);
        colorList.setLayoutManager(appearence);
        contactInfoList = new ArrayList();

        mImageButtonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                contactInfoList.add(new ContactInfo(mEditTextName.getText().toString(), mEditTextMobileNo.getText().toString(),
                        mEditTextCity.getText().toString()));
                colorList.setAdapter(new ContactAdapter(contactInfoList));
            }
        });
    }

    class ContactInfo {
        String name;
        String mobileNo;
        String city;
        ContactInfo(String name, String mobileNo, String city) {
            this.name     =  name;
            this.mobileNo =  mobileNo;
            this.city     =  city;
        }
    }

    public void hideKeyboard(View view) {
        view = getCurrentFocus();
        /*if (view != null) {*/
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            Log.d("hidekey", "hidden");
       /* }*/
    }

}
