package com.example.pfe_v3final.models;

import java.util.ArrayList;

public class CardModel {
    int image;
    String name , speciality , price ;

    public CardModel(int image, String name, String speciality, String price) {
        this.image = image;
        this.name = name;
        this.speciality = speciality;
        this.price = price;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
