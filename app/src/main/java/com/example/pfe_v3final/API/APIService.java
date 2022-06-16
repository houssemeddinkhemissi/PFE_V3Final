package com.example.pfe_v3final.API;
import com.example.pfe_v3final.models.LocationMatrix;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("distancematrix/json")
    Call<LocationMatrix> getData(@Query("origins") String originCoordinates,
                                 @Query("destinations") String destinationCoordinates,
                                 @Query("key") String token);
}
