package com.healthsignz.training.Model;

/**
 * Created by Lenovo on 07/04/2016.
 */
public class GroupItemData {

    String listGroupName;
    int imageExpandableIndicator;

    public GroupItemData(String listGroupName, int imageExpandableIndicator) {
        this.listGroupName = listGroupName;
        this.imageExpandableIndicator = imageExpandableIndicator;
    }

    public String getListGroupName() {
        return listGroupName;
    }

    public int getImageExpandableIndicator() {
        return imageExpandableIndicator;
    }
}
