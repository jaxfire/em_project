package com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaxfire.james_ash_earthmiles.Model.DataModel;
import com.jaxfire.james_ash_earthmiles.R;

public class AdapterRecyclerView extends RecyclerView.Adapter<RewardItemHolder>{

    private DataModel dataModel;
    int viewPagerPosition;

    public AdapterRecyclerView(int viewPagerPosition) {

        //TODO Use Dependency Injection to enable mocking of data layer
        dataModel = DataModel.getInstance();

        this.viewPagerPosition = viewPagerPosition;

    }

    @Override
    public RewardItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new RewardItemHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RewardItemHolder holder, int position) {
        holder.bindRewardItem(dataModel.getRewardItem(viewPagerPosition, position), viewPagerPosition, position, dataModel);
    }

    @Override
    public int getItemCount() {
        return dataModel.getItemCount(viewPagerPosition);
    }

    public void notifyImageLoaded(int index){
        this.notifyItemChanged(index);

    }

}