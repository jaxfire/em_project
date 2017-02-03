package com.jaxfire.pagerslidingtab;

public interface RewardsPagerContract {

    interface updaterewardsListener {

        //TODO Determine how the rewards are passed in
        void updateRewards();

    }

    interface loadImageListener {

        void onPageChanged(int position);

        void onRecyclerViewScroll();

    }

}
