package com.jaxfire.james_ash_earthmiles.Model;

import android.util.Log;
import android.widget.ImageView;

import com.jaxfire.james_ash_earthmiles.Categories;
import com.jaxfire.james_ash_earthmiles.Locations;
import com.jaxfire.james_ash_earthmiles.ViewLayer.LoadingScreen.LoadingScreen;
import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.ViewToDataModelContract;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataModel implements ViewToDataModelContract.RewardDataProvider, ViewToDataModelContract.ImageLoader {

    private static DataModel singletonInstance;

    ImageLoader imageLoader;
        DisplayImageOptions imageoptions;
    //TODO change to interface
    ViewToDataModelContract.JSONCallbackHandler jsonCallbackHandler;

    List<List<RewardItem>> rewardTypes = new ArrayList<>(3);
    ArrayList<RewardItem> nutrition, fitness, wellness;

    private DataModel() {

        //Holds the specific types of rewards
        nutrition = new ArrayList<>();
        fitness = new ArrayList<>();
        wellness = new ArrayList();

        //Adds them to one single Arraylist for ease of access later on
        rewardTypes.add(nutrition);
        rewardTypes.add(fitness);
        rewardTypes.add(wellness);

        //UIL options - cache to minimise bandwidth usage and provide a custom load-failed image
        imageoptions = new DisplayImageOptions.Builder()
                .showImageOnFail(R.drawable.em_recycler_view_item_failed)
                .cacheInMemory(true)
                .build();

        this.imageLoader = ImageLoader.getInstance();

        loadJson();
    }


    public static void initialise(ViewToDataModelContract.JSONCallbackHandler jsonCallbackHandler) {
        if (singletonInstance == null) {
            singletonInstance = new DataModel();
        }
        singletonInstance.jsonCallbackHandler = jsonCallbackHandler;
    }

    public static DataModel getInstance() {
        if (singletonInstance != null) {
            return singletonInstance;
        } else {
            //TODO - handle error, the DataModel should be initialised prior to use
            return null;
        }
    }

    public void loadJson() {

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        //Call the JSON
        Call<AllRewardData> call = api.getMyJSON();

        call.enqueue(new Callback<AllRewardData>() {
            @Override
            public void onResponse(Call<AllRewardData> call, Response<AllRewardData> response) {

                if (response.isSuccessful()) {

                    //The rewards from the returned json object
                    RewardItem[] theRewards = response.body().getResults();

                    for (RewardItem rewardItem : theRewards) {

                        //Filter by location - 'locations' can contain more than one location so we loop through them all
                        for (String s : rewardItem.getLocations()) {

                            //Using the UK only for this project
                            if (s.equals(Locations.UK.toString())) {

                                //Sort into the various categories
                                String rewardCategory = rewardItem.getCategory();

                                if (rewardCategory.equals(Categories.NUTRITION.toString())){
                                    rewardTypes.get(0).add(rewardItem);
                                }
                                if (rewardCategory.equals(Categories.FITNESS.toString())){
                                    rewardTypes.get(1).add(rewardItem);
                                }
                                if (rewardCategory.equals(Categories.WELLNESS.toString())){
                                    rewardTypes.get(2).add(rewardItem);
                                }

                            }
                        }
                    }

                    //Tell the loading screen to continue to the next activity
                    jsonCallbackHandler.loadJsonCallback(true);

                } else {
                    //TODO Report the error and let the user know that something went wrong
                    //Toast.makeText(MainActivity.this, "json call unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllRewardData> call, Throwable t) {
                jsonCallbackHandler.loadJsonCallback(false);
            }
        });

    }

    //ViewToDataModelContract interface
    public RewardItem getRewardItem(int viewPagerIndex, int rewardIndex) {

        return rewardTypes.get(viewPagerIndex).get(rewardIndex);

    }

    //From the Recyclerview adapters
    public int getItemCount(int viewPagerIndex) {

        return rewardTypes.get(viewPagerIndex).size();

    }

    //Download an image or get from cache and directly set it to the relevant TextView
    public void loadImage(int viewPagerPosition, int itemIndex, final ImageView imageView) {

        imageLoader.displayImage(rewardTypes.get(viewPagerPosition).get(itemIndex).getImage_320x280(), imageView);

    }
}