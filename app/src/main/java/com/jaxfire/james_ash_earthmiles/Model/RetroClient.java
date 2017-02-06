package com.jaxfire.james_ash_earthmiles.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Pratik Butani
 */
public class RetroClient {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://app.earthmiles.co.uk";

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
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
