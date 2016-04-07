package com.healthsignz.training.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.healthsignz.training.Model.ChildItemData;
import com.healthsignz.training.Model.GroupItemData;
import com.healthsignz.training.R;
import com.healthsignz.training.adapter.SocialNetworkAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListViewDemoActivity extends AppCompatActivity {

    private ExpandableListView mExpandableListViewNetwork;
    private List<String> listGroupItem;
    private LinkedHashMap<String, List<ChildItemData>> listChildItem;
    SocialNetworkAdapter adapter;
    ChildItemData group1, group2, group3, friend1, friend2, friend3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view_demo);

        mExpandableListViewNetwork = (ExpandableListView) findViewById(R.id.expandable_listview_network);
        prepareListData();
        adapter = new SocialNetworkAdapter(this, listGroupItem, listChildItem);
        mExpandableListViewNetwork.setAdapter(adapter);

        mExpandableListViewNetwork.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                ImageView imageView = (ImageView) findViewById(R.id.imageview_expandable_indicator);
                imageView.setImageResource(R.drawable.ic_down);
            }
        });

        mExpandableListViewNetwork.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                ImageView imageView = (ImageView) findViewById(R.id.imageview_expandable_indicator);
                imageView.setImageResource(R.drawable.ic_arrow);
            }
        });
    }

    public void prepareListData() {
        listGroupItem = new ArrayList<>();
        listChildItem = new LinkedHashMap<>();

        listGroupItem.add("Groups");
        listGroupItem.add("Friends");

        List<ChildItemData> groups = new ArrayList<>();
        group1 = new ChildItemData(R.drawable.alphabet, "meditation", "group1", "message1", "13:20");
        group2 = new ChildItemData(R.drawable.alphabet, "physical fitness", "group2", "message2", "14:20");
        group3 = new ChildItemData(R.drawable.alphabet, "weight management", "group3", "message3", "11:20");
        groups.add(group1); groups.add(group2); groups.add(group3);

        List<ChildItemData> friends = new ArrayList<>();
        friend1 = new ChildItemData(R.drawable.ic_edit, "meditation", "name1", "message1", "3:20");
        friend2 = new ChildItemData(R.drawable.ic_edit, "meditation", "name2", "message2", "4:20");
        friend3 = new ChildItemData(R.drawable.ic_edit, "meditation", "name3", "message3", "7:20");
        friends.add(friend1); friends.add(friend2); friends.add(friend3);

        listChildItem.put(listGroupItem.get(0), groups);
        listChildItem.put(listGroupItem.get(1), friends);
    }
}
