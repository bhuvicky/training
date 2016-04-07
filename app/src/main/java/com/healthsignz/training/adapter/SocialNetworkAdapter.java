package com.healthsignz.training.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.healthsignz.training.Model.ChildItemData;
import com.healthsignz.training.R;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Lenovo on 07/04/2016.
 */
public class SocialNetworkAdapter extends BaseExpandableListAdapter {

    Context context;
    private List<String> listGroupItem;
    private LinkedHashMap<String, List<ChildItemData>> listChildItem;

    public SocialNetworkAdapter(Context context, List<String> listGroupItem, LinkedHashMap<String, List<ChildItemData>> listChildItem) {
        this.context = context;
        this.listGroupItem = listGroupItem;
        this.listChildItem = listChildItem;
    }

    @Override
    public int getGroupCount() {
        return listGroupItem.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listChildItem.get(listGroupItem.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroupItem.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChildItem.get(listGroupItem.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_group, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }
        else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.textviewGroupName.setText(listGroupItem.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        ChildItemData childItemData;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_child_view, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }
        else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childItemData = (ChildItemData) getChild(groupPosition, childPosition);
        childViewHolder.icon.setImageResource(childItemData.getImage());
        childViewHolder.catageoryName.setText(childItemData.getCatageoryName());
        childViewHolder.name.setText(childItemData.getName());
        childViewHolder.message.setText(childItemData.getMessage());
        childViewHolder.time.setText(childItemData.getTime());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ChildViewHolder {
        protected ImageView icon;
        protected TextView catageoryName, name, message, time;

        public ChildViewHolder(View convertView) {
            icon = (ImageView) convertView.findViewById(R.id.imageView_icon);
            catageoryName = (TextView) convertView.findViewById(R.id.textView_category_name);
            name = (TextView) convertView.findViewById(R.id.textView_name);
            message = (TextView) convertView.findViewById(R.id.textView_message);
            time = (TextView) convertView.findViewById(R.id.textView_time);
        }
    }

    static class GroupViewHolder {
        protected TextView textviewGroupName;

        public GroupViewHolder(View convertView) {
            textviewGroupName = (TextView) convertView.findViewById(R.id.textView_list_group_name);
        }
    }
}
