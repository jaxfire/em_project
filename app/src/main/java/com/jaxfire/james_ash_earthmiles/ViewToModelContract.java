package com.jaxfire.james_ash_earthmiles;


import com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews.RewardItem;

public interface ViewToModelContract {

    //TODO
    interface ModelListener {
        //Implemented by the RecyclerView adapters

        void updateRewards(RewardItem rewardItem);

    }

    interface ViewListener {
        //Implemented by the DataModel layer

        void requestRewardItem(int position);

    }

}
