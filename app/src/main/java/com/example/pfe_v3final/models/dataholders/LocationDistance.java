package com.example.pfe_v3final.models.dataholders;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationDistance {

    @SerializedName("text")
    @Expose
    private String distance;

    public String getDistanceString() {
        return distance;
    }

    @SerializedName("value")
    @Expose
    private Integer value;

    public Integer getValue() {
        return value;
    }

    @NonNull
    @Override
    public String toString() {
        return distance;
    }
}
