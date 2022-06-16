package com.example.pfe_v3final.models;

import androidx.annotation.NonNull;

import com.example.pfe_v3final.models.dataholders.LocationDistance;
import com.example.pfe_v3final.models.dataholders.TrajectDuration;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationData {
    @SerializedName("distance")
    @Expose
    private LocationDistance locationDistance;

    public LocationDistance getLocationDistance() {
        return locationDistance;
    }

    @SerializedName("duration")
    @Expose
    private TrajectDuration trajectDuration;

    public TrajectDuration getTrajectDuration() {
        return trajectDuration;
    }

    @NonNull
    @Override
    public String toString() {
        return trajectDuration.toString() + " - " + locationDistance.toString();
    }
}
