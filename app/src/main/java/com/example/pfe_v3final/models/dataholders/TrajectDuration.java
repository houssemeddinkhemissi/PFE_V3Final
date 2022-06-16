package com.example.pfe_v3final.models.dataholders;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrajectDuration {
    @SerializedName("text")
    @Expose
    private String duration;

    public String getDuration() {
        return duration;
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
        return duration;
    }
}
