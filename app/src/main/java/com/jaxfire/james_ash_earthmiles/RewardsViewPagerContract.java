package com.jaxfire.james_ash_earthmiles;


import com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews.RewardItem;

public interface RewardsViewPagerContract {

    //TODO
    interface ViewImageHandler {
        //Implemented by the RecyclerView adapters

        void updateRewards(RewardItem rewardItem);

    }

    interface ModelRecyclerViewListener {
        //Implemented by the DataModel layer

        void onRecyclerViewScroll();

    }

}
