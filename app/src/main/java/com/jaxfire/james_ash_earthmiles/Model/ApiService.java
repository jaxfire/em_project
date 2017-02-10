package com.jaxfire.james_ash_earthmiles.Model;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Pratik Butani.
 */
public interface ApiService {

    //TODO Add in url
    @GET("/api/*********/********/********/?format=json")
    Call<AllRewardData> getMyJSON();
}
