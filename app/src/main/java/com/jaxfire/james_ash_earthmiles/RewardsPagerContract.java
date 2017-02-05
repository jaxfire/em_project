package com.jaxfire.james_ash_earthmiles;

public interface RewardsPagerContract {

    interface UpdateRewardsListener {

        //TODO Determine how the rewards are passed in
        //This will be implemented by the recyclerview adapters
        void updateRewards();

    }

    interface ViewListener {

        void onPageChanged(int position);

        void onRecyclerViewScroll();

    }

}
