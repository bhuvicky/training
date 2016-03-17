package com.healthsignz.training;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class NewContactActivity extends AppCompatActivity {

    TextInputLayout mInputLayoutName,mInputLayoutMobileNo, mInputLayoutCity;
    EditText mEditTextName, mEditTextMobileNo, mEditTextCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        mInputLayoutName     = (TextInputLayout) findViewById(R.id.input_layout_name);
        mInputLayoutMobileNo = (TextInputLayout) findViewById(R.id.input_layout_mobile_no);
        mInputLayoutCity     = (TextInputLayout) findViewById(R.id.input_layout_city);
        mEditTextName     = (EditText) findViewById(R.id.editText_name);
        mEditTextMobileNo = (EditText) findViewById(R.id.editText_phone);
        mEditTextCity     = (EditText) findViewById(R.id.editText_city);

    }
}
