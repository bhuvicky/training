package com.healthsignz.training.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.healthsignz.training.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 29/03/2016.
 */
public class UserDetailAdapter extends BaseAdapter {
    String[] labelNames, temp;
    Context context;
    ListView myList;
    public static ArrayList<String> validation;
    public UserDetailAdapter() {}

    public UserDetailAdapter(Context context, String[] labelNames, ListView myList) {
        this.context = context;
        this.labelNames = labelNames;
       temp = new String[labelNames.length];
        validation = new ArrayList<>();

        for (int i=0;i<16;i++){
            validation.add("");
        }

        this.myList = myList;
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
            Log.d("listview", "position = "+position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            holder = new MyViewHolder();
            holder.myPosition = position;

            if(whichType == 0) {
                row = inflater.inflate(R.layout.row_enter_details, parent, false);
                row.setTag(holder);

                holder.editTextEnterDetail = (EditText) row.findViewById(R.id.editText_enter_detail);
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
                            validation.remove(holder.myPosition/2);
                            validation.add(holder.myPosition/2, s.toString());
                        Log.v("records",validation.toString());
                    }
                });
            }
            else if(whichType == 1) {
                row = inflater.inflate(R.layout.row_spinner, parent, false);
                holder.spinnerColorList = (Spinner) row.findViewById(R.id.spinner_color);
                row.setTag(holder);
            }
        }
        else {
            Log.d("listview", "position = "+position);
            holder = (MyViewHolder) row.getTag();
            holder.myPosition = position;
            if (row instanceof RelativeLayout) {
                holder.editTextEnterDetail.setText(temp[position]);
                holder.editTextEnterDetail.setHint(labelNames[position]);
            }
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
    }
}
