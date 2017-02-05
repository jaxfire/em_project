package com.jaxfire.james_ash_earthmiles;

import android.util.Log;

public class PresenterRewardsPager implements RewardsPagerContract.ViewListener {

    ActivityRewards activityRewards;
    AdapterRewardsPager adapter;
    boolean initialImageBufferComplete;

    int initialPage = -1;

    public PresenterRewardsPager(ActivityRewards activityRewards, AdapterRewardsPager adapter){
        this.activityRewards = activityRewards;
        this.adapter = adapter;
    }

    public void onRecyclerViewScroll(){
        Log.d("jim", "onRecyclerViewScroll: ");
        //TODO load images for the current page's recycler view - make a call to downloadImages()
    }


    public void onPageChanged(int position){

        activityRewards.styleTitles(position);

        if (initialImageBufferComplete){
            return;
        }

        switch (position){

            case 0:
                Log.d("jim", "PresenterRewardsPager: Make call to buffer pages 0 and half for page 1");
                //TODO load buffers for page 0 and half for page 1 - make a call to downloadImages()
                break;

            case 1:
                if(initialPage == 0){
                    Log.d("jim", "PresenterRewardsPager: Make call to buffer pages 1 and half for page 2");
                    //TODO load buffers for page 1 and half for page 2 - make a call to downloadImages()
                } else {
                    Log.d("jim", "PresenterRewardsPager: Make call to buffer pages 1 and half for page 0");
                    //TODO load buffers for page 1 and half for page 0 - make a call to downloadImages()
                }

                initialImageBufferComplete = true;
                break;

            case 2:
                Log.d("jim", "PresenterRewardsPager: Make call to buffer pages 2 and half for page 1");
                //TODO load buffers for page 2 and half for page 1 - make a call to downloadImages()
                break;

        }

        if(initialPage == -1){
            this.initialPage = position;
        }

    }

    private void downLoadImages(){
        //TODO
    }

}
