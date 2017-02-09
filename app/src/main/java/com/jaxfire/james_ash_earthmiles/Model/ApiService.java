package com.jaxfire.james_ash_earthmiles.Model;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Pratik Butani.
 */
public interface ApiService {

    //TODO Add in url
    @GET("/api/v1/rewards/all_rewards/?format=json")
    Call<AllRewardData> getMyJSON();
}
