package com.jaxfire.pagerslidingtab;

import android.util.Log;

public class PresenterRewardsPager implements RewardsPagerContract.loadImageListener{

    ActivityRewards activityRewards;
    AdapterRewardsPager adapter;
    boolean initialImageBufferComplete;

    int initialPage = -1;

    public PresenterRewardsPager(ActivityRewards activityRewards, AdapterRewardsPager adapter){
        this.activityRewards = activityRewards;
        this.adapter = adapter;
    }

    public void onRecyclerViewScroll(){
        //TODO load images for the current page's recycler view
    }


    public void onPageChanged(int position){

        if (!initialImageBufferComplete){
            return;
        }

        switch (position){
            case 0:
                Log.d("jim", "PresenterRewardsPager: Buffering pages 0 and half for page 1");
                //TODO load buffers for page 0 and half for page 1
                break;

            case 1:
                if(initialPage == 0){
                    Log.d("jim", "PresenterRewardsPager: Buffering pages 1 and half for page 2");
                    //TODO load buffers for page 1 and half for page 2
                } else {
                    Log.d("jim", "PresenterRewardsPager: Buffering pages 1 and half for page 0");
                    //TODO load buffers for page 1 and half for page 0
                }

                initialImageBufferComplete = true;
                break;

            case 2:
                Log.d("jim", "PresenterRewardsPager: Buffering pages 2 and half for page 1");
                //TODO load buffers for page 2 and half for page 1
                break;

        }

        if(initialPage == -1){
            this.initialPage = position;
        }

    }

}
