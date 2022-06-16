package com.example.pfe_v3final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pfe_v3final.API.APIService;
import com.example.pfe_v3final.API.DistanceMatrixService;
import com.example.pfe_v3final.models.Element;
import com.example.pfe_v3final.models.LocationData;
import com.example.pfe_v3final.models.LocationMatrix;
import com.example.pfe_v3final.models.dataholders.LocationDistance;
import com.example.pfe_v3final.models.dataholders.TrajectDuration;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StartActivity extends AppCompatActivity {

    FusedLocationProviderClient mFusedLocationClient;
    private Double latitude,longitude;
    private HashMap<String, String> restaurantLocations;
    int PERMISSION_ID = 44;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage();
            }
        });
        Button fetchButton = findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchLocationAndLookForDistances();
            }
        });



        mFusedLocationClient = new FusedLocationProviderClient(this);

        restaurantLocations = new HashMap<String, String>();
        restaurantLocations.put("37.2811363,9.8264847","");
        restaurantLocations.put("38.2811363,7.8264847","");
        restaurantLocations.put("36.2811363,4.8264847","");
        restaurantLocations.put("31.2811363,9.8264847","");
        restaurantLocations.put("39.2811363,3.8264847","");


    }
    public void nextpage(){
        Intent intent = new Intent(this,AuthActivity.class);
        startActivity(intent);
    }






    ///LOCATION FETCH



    public void printdata(){
        for (String coordinatesRestaurant: restaurantLocations.values()) {
            Log.d("locaions",coordinatesRestaurant);
        }
    }
    public void getLocationMatrix(String coordinatesRestaurant){
        String accessToken = BuildConfig.ACCESS_TOKEN;
        String coordinateHere = latitude  + "," + longitude;
        //Creating an object of our api interface
        APIService api = DistanceMatrixService.getApiService();
        /**
         * Calling JSON
         */
        Call<LocationMatrix> call = api.getData(coordinateHere,coordinatesRestaurant,accessToken);
        View parentLayout = findViewById(android.R.id.content);
        call.enqueue(new Callback<LocationMatrix>() {
            @Override
            public void onResponse(Call<LocationMatrix> call, Response<LocationMatrix> response) {
                if (response.isSuccessful()){
                    String destination = response.body().getDestinationAddress();
                    String origin = response.body().getOriginAddress();
                    Element element = response.body().getElement();
                    if (element != null) {
                        LocationData locationData = element.getLocationData();
                        if (locationData != null) {
                            LocationDistance locationDistance =   locationData.getLocationDistance();
                            TrajectDuration trajectDuration = locationData.getTrajectDuration();
                            String distance = "" ;
                            String duration = "" ;
                            if (locationDistance != null) distance = locationDistance.getDistanceString();
                            if (trajectDuration != null) duration = trajectDuration.getDuration();
                            restaurantLocations.put(coordinatesRestaurant, origin + " -> " + destination + " - Distance: " + distance + " - Duration: " + duration);
                        }

                    }
                    printdata();
                }else {
                    Snackbar.make(parentLayout, "ERROR for "+coordinatesRestaurant, Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LocationMatrix> call, Throwable t) {
                Snackbar.make(parentLayout, "ERROR for "+coordinatesRestaurant, Snackbar.LENGTH_LONG).show();
            }

        });

    }





















    @SuppressLint("MissingPermission")
    private void fetchLocationAndLookForDistances() {
        // check if permissions are given
        if (checkPermissions()) {

            // check if location is enabled
            if (isLocationEnabled()) {

                // getting last
                // location from
                // FusedLocationClient
                // object
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                            for (String coordinatesRestaurant: restaurantLocations.keySet()) {
                                getLocationMatrix(coordinatesRestaurant);
                            }
                        }
                    }
                });
            } else {
                Snackbar.make(findViewById(android.R.id.content), "ERROR", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }
    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            latitude = mLastLocation.getLatitude();
            longitude = mLastLocation.getLongitude();
            for (String coordinatesRestaurant: restaurantLocations.keySet()) {
                getLocationMatrix(coordinatesRestaurant);
            }
        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // If everything is alright then
    @Override
    public void
    onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocationAndLookForDistances();
            }
        }
    }

}