package com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaxfire.james_ash_earthmiles.Model.DataModel;
import com.jaxfire.james_ash_earthmiles.Model.RewardItem;
import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.ViewLayer.RewardPurchaseScreen.ActivityRewardPurchase;

public class RewardItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private DataModel dataModel;

    private TextView name;
    private TextView shortDescription;
    private TextView emCost;
    private TextView realValue;
    private ImageView itemImage;

    int viewPagerPosition;
    int itemIndex;

    public RewardItemHolder(View v, DataModel datamodel) {
        super(v);

        this.dataModel = datamodel;

        name = (TextView) v.findViewById(R.id.name);
        shortDescription = (TextView) v.findViewById(R.id.short_description);
        emCost = (TextView) v.findViewById(R.id.item_em_cost);
        realValue = (TextView) v.findViewById(R.id.real_world_value);
        itemImage = (ImageView) v.findViewById(R.id.item_image);

        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Context context = itemView.getContext();
        Intent rewardsPageintent = new Intent(context, ActivityRewardPurchase.class);
        RewardItem rewardItem = dataModel.getRewardItem(viewPagerPosition, itemIndex);
        rewardsPageintent.putExtra("name", rewardItem.getReward_partner().getName());
        rewardsPageintent.putExtra("short_description", rewardItem.getShort_description());
        rewardsPageintent.putExtra("validity", rewardItem.getValidity());
        rewardsPageintent.putExtra("availing", rewardItem.getAvailing());
        rewardsPageintent.putExtra("location", rewardItem.getLocation());
        rewardsPageintent.putExtra("timing", rewardItem.getTiming());
        rewardsPageintent.putExtra("logo", rewardItem.getReward_partner().getImage_web());
        rewardsPageintent.putExtra("imageURL", rewardItem.getImage_320x280());

        context.startActivity(rewardsPageintent);
    }

    public void bindRewardItem(RewardItem rewardItem, int viewPagerPosition, int itemIndex) {

        this.viewPagerPosition = viewPagerPosition;
        this.itemIndex = itemIndex;

        name.setText(rewardItem.getReward_partner().getName());
        shortDescription.setText(rewardItem.getShort_description());
        emCost.setText(rewardItem.getPoints() + " em");
        realValue.setText(rewardItem.getPound_value_text());

        //Manually setting the loading image seems to work better than UIL's showImageOnLoading() feature
        itemImage.setImageResource(R.drawable.em_recycler_view_item_loading);
        dataModel.loadImage(viewPagerPosition, itemIndex, itemImage);

    }

}