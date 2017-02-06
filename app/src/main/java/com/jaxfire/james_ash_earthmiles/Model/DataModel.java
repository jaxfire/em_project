package com.jaxfire.james_ash_earthmiles.Model;

import android.util.Log;

import com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews.RewardItem;
import com.jaxfire.james_ash_earthmiles.ViewToModelContract;

import java.util.HashMap;

public class DataModel implements ViewToModelContract.ViewListener {

    private static DataModel singletonInstance;
    private HashMap<Integer, ViewToModelContract.ModelListener> adapters;

    public static DataModel getInstance(int position, ViewToModelContract.ModelListener adapter){
        if (singletonInstance == null){
            singletonInstance = new DataModel();
        }
        singletonInstance.addAdapter(position, adapter);
        return singletonInstance;
    }

    private DataModel(){
        Log.d("jim", "new model created");
        adapters = new HashMap<>();
    }

    private void addAdapter(int position, ViewToModelContract.ModelListener adapter){
        adapters.put(position, adapter);
    }

    public void requestRewardItem(int viewPagerIndex){
        Log.d("jim", "onRecyclerViewScroll: ");
        //TODO load images for the current page's recycler view
        adapters.get(viewPagerIndex).updateRewards(new RewardItem("Company Name", String.valueOf(viewPagerIndex)));

    }

}