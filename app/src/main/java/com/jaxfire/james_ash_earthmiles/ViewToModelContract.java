package com.jaxfire.james_ash_earthmiles;


import com.jaxfire.james_ash_earthmiles.Model.RewardItem;

public interface ViewToModelContract {

    //TODO
    interface ModelListener {
        //Implemented by the RecyclerView adapters

        void notifyImageLoaded(int i);

    }

    interface ViewListener {
        //Implemented by the DataModel layer

        RewardItem getRewardItem(int viewPagerIndex, int rewardIndex);

    }

}
