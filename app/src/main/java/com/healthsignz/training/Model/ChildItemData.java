package com.healthsignz.training.Model;

/**
 * Created by Lenovo on 07/04/2016.
 */
public class ChildItemData {

    int image;
    String catageoryName, name, message, time;

    public ChildItemData(int image, String catageoryName, String name, String message, String time) {
        this.image = image;
        this.catageoryName = catageoryName;
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public String getCatageoryName() {
        return catageoryName;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }
}
