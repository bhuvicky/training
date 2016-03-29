package com.healthsignz.training;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lenovo on 23/03/2016.
 */

    public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

        List<RecyclerViewDemoActivity.ContactInfo> dataSet;
        int colorChangedPosition=-4;
        View itemView;

        ContactAdapter(List dataSet) {
            this.dataSet = dataSet;
        }

        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.contact_card, parent, false);
            return new ContactViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ContactViewHolder holder, int position) {
            holder.textViewTitle.setText(dataSet.get(position).name);
            holder.textViewName.setText(dataSet.get(position).mobileNo);
            holder.textViewMobileNo.setText(dataSet.get(position).city);
            Log.i("logcheck", "inside on bind");

            if (colorChangedPosition == position)
                holder.relativeLayout.setBackgroundColor(Color.BLUE);
            else
                holder.relativeLayout.setBackgroundColor(Color.WHITE);
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

        class ContactViewHolder extends RecyclerView.ViewHolder {
            TextView textViewTitle, textViewName, textViewMobileNo;
            EditText editTextCountry;
            ImageButton mImageButtonEdit;
            RelativeLayout relativeLayout ;
            public ContactViewHolder(final View itemView) {
                super(itemView);
                relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rLayout_cardView);
                textViewTitle = (TextView) itemView.findViewById(R.id.textView_fill_name);
                textViewName = (TextView) itemView.findViewById(R.id.textView_fill_number);
                textViewMobileNo = (TextView) itemView.findViewById(R.id.textView_fill_city);
                editTextCountry = (EditText) itemView.findViewById(R.id.editText_country);
                mImageButtonEdit = (ImageButton) itemView.findViewById(R.id.button_editView);

                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("logcheck", "inside on click listener");
                        if (colorChangedPosition == getAdapterPosition()) {
                            colorChangedPosition = -4;
                            notifyDataSetChanged();
                        } else {
                            colorChangedPosition = getAdapterPosition();
                            notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }

