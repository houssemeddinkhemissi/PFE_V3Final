package com.example.pfe_v3final.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DistanceMatrixService {
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://api.distancematrix.ai/maps/api/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {

        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static APIService getApiService() {
        return getRetrofitInstance().create(APIService.class);
    }
}
