package com.jaxfire.james_ash_earthmiles;


import android.widget.ImageView;

import com.jaxfire.james_ash_earthmiles.Model.RewardItem;

public interface ViewToDataModelContract {

    //DataModel
    interface ImageLoader {
        void loadImage(int viewPagerPosition, int itemIndex, final ImageView imageView);
    }

    interface RewardDataProvider {
        int getItemCount(int viewPagerIndex);
        RewardItem getRewardItem(int viewPagerIndex, int rewardIndex);
    }

    //Loading screen
    interface JSONCallbackHandler {

        void loadJsonCallback(boolean loadSuccess);

    }

}
