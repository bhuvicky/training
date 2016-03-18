package com.healthsignz.training;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class NewContactActivity extends AppCompatActivity {

    EditText mEditTextName, mEditTextMobileNo, mEditTextCity, mEditTextItemPosition;
    Intent intentContactDetail;
    public static int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        mEditTextName     = (EditText) findViewById(R.id.editText_name);
        mEditTextMobileNo = (EditText) findViewById(R.id.editText_phone);
        mEditTextCity     = (EditText) findViewById(R.id.editText_city);
        mEditTextItemPosition = (EditText) findViewById(R.id.editText_item_position);
        mEditTextItemPosition.setVisibility(View.INVISIBLE);
        try {
            if(getIntent().getStringExtra("edit").equals("contact")) {
                mEditTextItemPosition.setVisibility(View.VISIBLE);
            }
        } catch (NullPointerException ex) {
            count++;
        }

        intentContactDetail = new Intent();
    }

    @Override
    public void onBackPressed() {
        intentContactDetail.putExtra("name", mEditTextName.getText().toString());
        intentContactDetail.putExtra("phone", mEditTextMobileNo.getText().toString());
        intentContactDetail.putExtra("city", mEditTextCity.getText().toString());
        intentContactDetail.putExtra("item position to edit", mEditTextItemPosition.getText().toString());
        intentContactDetail.putExtra("total item", count);
        setResult(Activity.RESULT_OK, intentContactDetail);
        super.onBackPressed();
    }


}
