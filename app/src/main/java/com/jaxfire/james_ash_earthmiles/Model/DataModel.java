package com.jaxfire.james_ash_earthmiles.Model;

import android.util.Log;

import com.jaxfire.james_ash_earthmiles.LoadingScreen.LoadingScreen;
import com.jaxfire.james_ash_earthmiles.ViewToModelContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataModel implements ViewToModelContract.ViewListener {

    private static DataModel singletonInstance;
    LoadingScreen loadingScreen;
    ArrayList<RewardItem> nutrition;
    ArrayList<RewardItem> fitness;
    ArrayList<RewardItem> wellness;
    private HashMap<Integer, ViewToModelContract.ModelListener> adapters;

    private DataModel() {
        Log.d("jim", "new model created");
        adapters = new HashMap<>();
        loadJson();
    }

    public static void initialise(LoadingScreen loadingScreen) {
        Log.d("jim", "initialise: ");
        if (singletonInstance == null) {
            singletonInstance = new DataModel();
        }
        singletonInstance.loadingScreen = loadingScreen;
        singletonInstance.loadJson();
    }

    public static DataModel getInstance(int position, ViewToModelContract.ModelListener adapter) {
        if (singletonInstance != null) {
            Log.d("jim", "getInstance: singletonInstance is not null");
            singletonInstance.addAdapter(position, adapter);
            return singletonInstance;
        } else{
            Log.d("jim", "The data model was not initialised");
            return null;
        }
    }

    private void addAdapter(int position, ViewToModelContract.ModelListener adapter) {
        adapters.put(position, adapter);
    }

    public void loadJson() {

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        //Calling JSON
        Call<AllRewardData> call = api.getMyJSON();

        //Enqueue Callback will be called when get response...
        call.enqueue(new Callback<AllRewardData>() {
            @Override
            public void onResponse(Call<AllRewardData> call, Response<AllRewardData> response) {

                if (response.isSuccessful()) {

                    //The actual results (rewards) from the returned json object
                    RewardItem[] theRewards = response.body().getResults();

                    nutrition = new ArrayList<>();
                    fitness = new ArrayList<>();
                    wellness = new ArrayList<>();

                    for (RewardItem rewardItem : theRewards) {
                        switch (rewardItem.getCategory()) {
                            case "Nutrition":
                                nutrition.add(rewardItem);
                                break;
                            case "Fitness":
                                fitness.add(rewardItem);
                                break;

                            case "Wellness":
                                wellness.add(rewardItem);
                                break;
                        }
                    }

                    //Sort the reward items (newest to oldest) - based on the presumption that ids increment over time.
                    Collections.sort(nutrition);
                    Collections.sort(fitness);
                    Collections.sort(wellness);

                    loadingScreen.loadJsonCallback(true);

                } else {
                    //Toast.makeText(MainActivity.this, "json call unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllRewardData> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                //dialog.dismiss();
                loadingScreen.loadJsonCallback(false);
            }
        });

    }


    //ViewToModelContract interface
    public RewardItem getRewardItem(int viewPagerIndex, int rewardIndex) {

        Log.d("jim", "" + viewPagerIndex + " " + rewardIndex);

        //TODO check for no more rewards here

        RewardItem temp;

        switch (viewPagerIndex) {
            case 0:
                temp = nutrition.get(rewardIndex);
                break;
            case 1:
                temp = fitness.get(rewardIndex);
                break;

            case 2:
                temp = wellness.get(rewardIndex);
                break;
            default:
                temp = null;
                break;
        }

        return temp;

        //Create an empty reward item

    }

}