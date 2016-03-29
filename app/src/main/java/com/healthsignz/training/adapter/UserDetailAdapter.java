package com.healthsignz.training.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.healthsignz.training.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 29/03/2016.
 */
public class UserDetailAdapter extends BaseAdapter {
    String[] labelNames;
    String[] temp;
    Context context;
    public UserDetailAdapter(Context context, String[] labelNames) {
        this.context = context;
        this.labelNames = labelNames;
       temp = new String[labelNames.length];
    }

    @Override
    public int getCount() {
        return labelNames.length;
    }

    @Override
    public Object getItem(int position) {
        return labelNames[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        int whichType = getItemViewType(position);
        final MyViewHolder holder;
        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            holder = new MyViewHolder();
            if(whichType == 0) {
                row = inflater.inflate(R.layout.row_enter_details, parent, false);
                holder.editTextEnterDetail = (EditText) row.findViewById(R.id.editText_enter_detail);
                holder.myPosition = position;

                holder.editTextEnterDetail.setHint(labelNames[position]);
                holder.editTextEnterDetail.setText(temp[position]);
                holder.editTextEnterDetail.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        temp[holder.myPosition] = s.toString();
                    }
                });
            }
            if(whichType == 1) {
                row = inflater.inflate(R.layout.row_spinner, parent, false);
                holder.spinnerColorList = (Spinner) row.findViewById(R.id.spinner_color);
            }

            Log.d("check", ""+row);
            row.setTag(holder);

        }

        else {
            holder = (MyViewHolder) row.getTag();
        }

        return row;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2 == 0 ? 0:1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public static class MyViewHolder {
        EditText editTextEnterDetail;
        Spinner spinnerColorList;
        int myPosition;

        /*public MyViewHolder(View row) {
            editTextEnterDetail = (EditText) row.findViewById(R.id.editText_enter_detail);
            spinnerColorList = (Spinner) row.findViewById(R.id.spinner_color);
        }*/
    }


}
