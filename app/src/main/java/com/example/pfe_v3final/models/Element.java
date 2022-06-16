package com.example.pfe_v3final.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Element {
    @SerializedName("elements")
    @Expose
    private ArrayList<LocationData> locationData;

    public LocationData getLocationData() {
        return locationData.get(0);
    }

    @NonNull
    @Override
    public String toString() {
        return locationData.toString();
    }
}
