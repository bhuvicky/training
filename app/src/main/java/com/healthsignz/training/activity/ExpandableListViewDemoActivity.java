package com.healthsignz.training.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.healthsignz.training.Model.ChildItemData;
import com.healthsignz.training.Model.GroupItemData;
import com.healthsignz.training.R;
import com.healthsignz.training.adapter.SocialNetworkAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListViewDemoActivity extends AppCompatActivity {

    private ExpandableListView mExpandableListViewNetwork;
    private List<GroupItemData> listGroupItem;
    private LinkedHashMap<String, List<ChildItemData>> listChildItem;
    SocialNetworkAdapter adapter;
    ChildItemData group1, group2, group3, friend1, friend2, friend3;
    GroupItemData header1, header2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view_demo);

        mExpandableListViewNetwork = (ExpandableListView) findViewById(R.id.expandable_listview_network);
        prepareListData();
        adapter = new SocialNetworkAdapter(this, listGroupItem, listChildItem, mExpandableListViewNetwork);
        mExpandableListViewNetwork.setAdapter(adapter);

    }

    public void prepareListData() {
        listGroupItem = new ArrayList<>();
        listChildItem = new LinkedHashMap<>();

        header1 = new GroupItemData("Groups", R.drawable.ic_arrow, R.drawable.ic_down);
        header2 = new GroupItemData("Friends", R.drawable.ic_arrow, R.drawable.ic_down);
        listGroupItem.add(header1); listGroupItem.add(header2);

        List<ChildItemData> groups = new ArrayList<>();
        group1 = new ChildItemData(R.drawable.alphabet, "meditation", "group1", "message1", "13:20");
        group2 = new ChildItemData(R.drawable.alphabet, "physical fitness", "group2", "message2", "14:20");
        group3 = new ChildItemData(R.drawable.alphabet, "weight management", "group3", "message3", "11:20");
        groups.add(group1); groups.add(group2); groups.add(group3);

        List<ChildItemData> friends = new ArrayList<>();
        friend1 = new ChildItemData(R.drawable.ic_edit, "name1", "message1", "3:20");
        friend2 = new ChildItemData(R.drawable.ic_edit, "name2", "message2", "4:20");
        friend3 = new ChildItemData(R.drawable.ic_edit, "name3", "message3", "7:20");
        friends.add(friend1); friends.add(friend2); friends.add(friend3);

        listChildItem.put(listGroupItem.get(0).getListGroupName(), groups);
        listChildItem.put(listGroupItem.get(1).getListGroupName(), friends);
    }
}
