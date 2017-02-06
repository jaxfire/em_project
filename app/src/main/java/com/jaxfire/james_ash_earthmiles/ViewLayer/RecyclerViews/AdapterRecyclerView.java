package com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.RewardsViewPagerContract;
import com.jaxfire.james_ash_earthmiles.RewardsViewPresenterContract;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<RewardItemHolder> implements RewardsViewPagerContract.ViewImageHandler {

    private ArrayList<RewardItem> rewardItems;

    public AdapterRecyclerView() {
        if (false){
            //TODO
            //Check the cache to see if we already have items downloaded
            //oooooor... link this directly to the cache????
            //However this is not great for MVP and testing
        }else {
            //Create an empty list of reward items
            this.rewardItems = new ArrayList<>();
        }
    }

    @Override
    public RewardItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new RewardItemHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RewardItemHolder holder, int position) {
        holder.bindRewardItem(rewardItems.get(position));
    }

    @Override
    public int getItemCount() {
        return rewardItems.size();
    }

    public void updateRewards(RewardItem rewardItem) {
        this.rewardItems.add(rewardItem);
        //TODO check if there is a more specific data update call
        this.notifyDataSetChanged();
    }
}
