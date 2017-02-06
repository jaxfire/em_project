package com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaxfire.james_ash_earthmiles.Model.DataModel;
import com.jaxfire.james_ash_earthmiles.Model.RewardItem;
import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.ViewToModelContract;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<RewardItemHolder> implements ViewToModelContract.ModelListener {

    private DataModel dataModel;
    int viewPagerPosition;

    public AdapterRecyclerView(int viewPagerPosition) {
        //TODO Use Dependency Injection to enable mocking of data layer
        dataModel = DataModel.getInstance(viewPagerPosition, this);
    }

    public void requestRewardItem(int index){
        dataModel.requestRewardItem(viewPagerPosition, index);
    }

    @Override
    public RewardItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new RewardItemHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RewardItemHolder holder, int position) {
        holder.bindRewardItem(dataModel.re(position));
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
