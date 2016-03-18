package com.healthsignz.training;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 15/03/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    List<RecyclerViewDemoActivity.ContactInfo> dataSet;

    ContactAdapter(List dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.contact_card, parent, false);
        Log.d("recyle", "onCreateViewHolder called, viewType = " + viewType);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        // position = itemPosition;
        Log.d("recyle", "onBindViewHolder called, row reference = " + holder);
        holder.textViewTitle.setText(dataSet.get(position).name);
        holder.textViewName.setText(dataSet.get(position).mobileNo);
        holder.textViewMobileNo.setText(dataSet.get(position).city);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewName, textViewMobileNo;
        ImageButton mImageButtonEdit;

        public ContactViewHolder(View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textView_fill_name);
            textViewName = (TextView) itemView.findViewById(R.id.textView_fill_number);
            textViewMobileNo = (TextView) itemView.findViewById(R.id.textView_fill_city);
            mImageButtonEdit = (ImageButton) itemView.findViewById(R.id.button_editView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataSet.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });

           /* mImageButtonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(mImageButtonEdit.getContext());
                    dialog.setTitle("Enter Details");
                    dialog.setContentView(R.layout.activity_new_contact);
                    dialog.show();
                    EditText mEditTextName     = (EditText) dialog.findViewById(R.id.editText_name);
                    EditText mEditTextMobileNo = (EditText) dialog.findViewById(R.id.editText_phone);
                    EditText mEditTextCity     = (EditText) dialog.findViewById(R.id.editText_city);
                    Button mButtonCancel = (Button) dialog.findViewById(R.id.button_cancel);
                    Button mButtonOk     = (Button) dialog.findViewById(R.id.button_ok);
                    mButtonOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                    });
                }
            });
        }
    }*/
}
