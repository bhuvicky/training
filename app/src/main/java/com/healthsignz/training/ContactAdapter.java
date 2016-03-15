package com.healthsignz.training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Lenovo on 15/03/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    String[] title;
    String[] name;
    String[] mobileNo;

    ContactAdapter (String[] title, String[] name, String[] mobileNo) {
        this.title = title;
        this.name  = name;
        this.mobileNo = mobileNo;
    }
    @Override
    public  ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.contact_card, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.textViewTitle.setText(title[position]);
        holder.textViewName.setText(name[position]);
        holder.textViewMobileNo.setText(mobileNo[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewName, textViewMobileNo;

        public ContactViewHolder(View itemView) {
            super(itemView);
            textViewTitle    = (TextView) itemView.findViewById(R.id.textView_title);
            textViewName     = (TextView) itemView.findViewById(R.id.textView_fill_name);
            textViewMobileNo = (TextView) itemView.findViewById(R.id.textView_fill_number);

        }
    }
}
