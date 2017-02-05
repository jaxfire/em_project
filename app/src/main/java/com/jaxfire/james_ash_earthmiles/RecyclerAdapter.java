package com.jaxfire.james_ash_earthmiles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RewardItemHolder> {

    private ArrayList<RewardItem> rewardItems;

    public RecyclerAdapter() {
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

    //May not be needing if we link directly to the cache
    public void addRewardItem(RewardItem rewardItem){
        this.rewardItems.add(rewardItem);
    }

}
