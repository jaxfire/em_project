package com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

        //This was the missed assignment! 4 hours!
        this.viewPagerPosition = viewPagerPosition;

        //TODO Use Dependency Injection to enable mocking of data layer
        Log.d("adapter1", "recycler adapter created " + viewPagerPosition);
        dataModel = DataModel.getInstance(viewPagerPosition, this);
    }

    /*public void requestRewardItem(int index){
        Log.d("indexTest", "requestRewardItem: " + index);
        dataModel.getRewardItem(viewPagerPosition, index);
    }*/

    @Override
    public RewardItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new RewardItemHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RewardItemHolder holder, int position) {
        holder.bindRewardItem(dataModel.getRewardItem(viewPagerPosition, position));
    }

    @Override
    public int getItemCount() {
        return dataModel.getNumOfRewardItems(viewPagerPosition);
    }

    public void notifyImageLoaded(int index){
        Log.d("loadImage", "viewpager position: " + viewPagerPosition + " image index: " + index);
        //TODO check if there is a more specific data update call than notifyDataSetChanged()
        this.notifyDataSetChanged();
        //this.notifyItemChanged(index);
        //this.rewardItems.add(rewardItem);

    }
}
