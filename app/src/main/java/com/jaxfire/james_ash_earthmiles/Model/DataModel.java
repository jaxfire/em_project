package com.jaxfire.james_ash_earthmiles.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import com.jaxfire.james_ash_earthmiles.LoadingScreen.LoadingScreen;
import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.ViewToModelContract;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataModel implements ViewToModelContract.ViewListener {

    private static DataModel singletonInstance;
    Context context;
    ImageLoader imageLoader;
    LoadingScreen loadingScreen;
    List<List<RewardItem>> rewardTypes = new ArrayList<>(3);
    ArrayList<RewardItem> nutrition;
    ArrayList<RewardItem> fitness;
    ArrayList<RewardItem> wellness;
    private ViewToModelContract.ModelListener[] adapters = new ViewToModelContract.ModelListener[3];

    private DataModel() {

    }

    public static void initialise(LoadingScreen loadingScreen, ImageLoader imageLoader) {
        Log.d("jim", "initialise: ");
        if (singletonInstance == null) {
            singletonInstance = new DataModel();
        }
        singletonInstance.imageLoader = imageLoader;
        singletonInstance.loadingScreen = loadingScreen;
        singletonInstance.loadJson();
    }

    public static DataModel getInstance(int position, ViewToModelContract.ModelListener adapter) {
        if (singletonInstance != null) {
            Log.d("adapter1", "getInstance: position = " + position);
            singletonInstance.addAdapter(position, adapter);
            return singletonInstance;
        } else {
            Log.d("jim", "The data model was not initialised");
            return null;
        }
    }

    //TODO remove - only for testing. Used with the test loadImage button
    public static DataModel getInstance(Context context) {
        singletonInstance.context = context;
        return singletonInstance;
    }

    private void addAdapter(int position, ViewToModelContract.ModelListener adapter) {
        adapters[position] = adapter;
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
                    wellness = new ArrayList();

                    rewardTypes.add(nutrition);
                    rewardTypes.add(fitness);
                    rewardTypes.add(wellness);

                    for (RewardItem rewardItem : theRewards) {

                        for (String s : rewardItem.getLocations()) {

                            //Using the UK only for the project
                            if (s.equals("Available throughout UK")) {

                                switch (rewardItem.getCategory()) {

                                    case "Nutrition":
                                        rewardTypes.get(0).add(rewardItem);
                                        break;
                                    case "Fitness":
                                        rewardTypes.get(1).add(rewardItem);
                                        break;

                                    case "Wellness":
                                        rewardTypes.get(2).add(rewardItem);
                                        break;

                                }
                            }
                        }
                    }

                    Log.d("adapter1", "nutrition size " + rewardTypes.get(0).size());
                    Log.d("adapter1", "fitness size " + rewardTypes.get(1).size());
                    Log.d("adapter1", "wellness size " + rewardTypes.get(2).size());

                    //Sort the reward items (newest to oldest) - based on the presumption that ids increment over time.
                    //They appear to already be in the correct order so no sort is required
                    //Collections.sort(rewardTypes.get(0));
                    //Collections.sort(rewardTypes.get(1));
                    //Collections.sort(rewardTypes.get(2));

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

        //TODO check for no more rewards here
        Log.d("jim", "" + viewPagerIndex + " " + rewardIndex);

        return rewardTypes.get(viewPagerIndex).get(rewardIndex);

    }

    //for the ViewPager
    public int getNumOfRewardItems(int viewPagerIndex) {

        return rewardTypes.get(viewPagerIndex).size();

    }

    public void loadImage(final int viewPagerIndex, final int rewardIndex) {

        Log.d("loadImage", "loadImage: " + viewPagerIndex);

        final RewardItem tempReward = rewardTypes.get(viewPagerIndex).get(rewardIndex);

        imageLoader.loadImage(tempReward.getImage_320x280(), new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                tempReward.setLoadedImage(loadedImage);
                tempReward.setHasImageLoaded(true);
                Log.d("whichAdpater", "" + viewPagerIndex);
                adapters[viewPagerIndex].notifyImageLoaded(rewardIndex);
            }
        });
    }

}