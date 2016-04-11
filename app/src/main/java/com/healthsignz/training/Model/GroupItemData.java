package com.healthsignz.training.Model;

/**
 * Created by Lenovo on 07/04/2016.
 */
public class GroupItemData {

    String listGroupName;
    int imageExpandableIndicator;
    int imageGroupCollapseIndicator;

    public GroupItemData(String listGroupName, int imageGroupCollapseIndicator, int imageExpandableIndicator) {
        this.listGroupName = listGroupName;
        this.imageExpandableIndicator = imageExpandableIndicator;
        this.imageGroupCollapseIndicator = imageGroupCollapseIndicator;
    }

    public String getListGroupName() {
        return listGroupName;
    }

    public int getImageExpandableIndicator() {
        return imageExpandableIndicator;
    }

    public int getImageGroupCollapseIndicator() {
        return imageGroupCollapseIndicator;
    }
}
