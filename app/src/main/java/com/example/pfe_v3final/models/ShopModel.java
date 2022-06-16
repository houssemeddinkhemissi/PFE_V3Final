package com.example.pfe_v3final.models;

public class ShopModel {
    int image;
    String name , Adresse ;

    public ShopModel(int image, String name, String adresse) {
        this.image = image;
        this.name = name;
        Adresse = adresse;
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

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }
}
