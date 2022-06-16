package com.example.pfe_v3final.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LocationMatrix {
    @SerializedName("destination_addresses")
    @Expose
    private ArrayList<String> destinationAdresses;

    @SerializedName("origin_addresses")
    @Expose
    private ArrayList<String> originAdresses;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("rows")
    @Expose
    private ArrayList<Element> elements;

    public Element getElement() {
        return elements.get(0);
    }

    public String getDestinationAddress() {
        return destinationAdresses.get(0);
    }

    public String getOriginAddress() {
        return originAdresses.get(0);
    }

    public Boolean isSuccessfull() {
        return status == "Ok";
    }

    @NonNull
    @Override
    public String toString() {
        return elements.toString();
    }
}
