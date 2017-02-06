package com.jaxfire.james_ash_earthmiles.Model;

import android.util.Log;

import com.jaxfire.james_ash_earthmiles.RewardsViewPagerContract;

public class DataModel implements RewardsViewPagerContract.ModelRecyclerViewListener {

    private static DataModel singletonInstance;

    public static DataModel getInstance(){
        if (singletonInstance == null){
            singletonInstance = new DataModel();
        }
        return singletonInstance;
    }

    private DataModel(){

    }

    public void onRecyclerViewScroll(){
        Log.d("jim", "onRecyclerViewScroll: ");
        //TODO load images for the current page's recycler view - make a call to downloadImages()

    }

}