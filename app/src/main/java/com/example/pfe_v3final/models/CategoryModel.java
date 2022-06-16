package com.example.pfe_v3final.models;

public class CategoryModel {
    int image;
    String Distance , Time ;

    public CategoryModel(int image, String distance, String time) {
        this.image = image;
        Distance = distance;
        Time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
