package com.jaxfire.james_ash_earthmiles;

public interface RewardsViewPresenterContract {

    //TODO
    interface UIHandler {
        //Implemented by the main UI activity adapters

        void styleTitles(int position);

    }


    //TODO
    interface ImageHandler {
        //Implemented by the RecyclerView adapters

        void updateRewards();

    }

    interface ViewListener {
        //Implemented by the Presenter layer

        void onPageChanged(int position);

        void onRecyclerViewScroll();

    }

}
