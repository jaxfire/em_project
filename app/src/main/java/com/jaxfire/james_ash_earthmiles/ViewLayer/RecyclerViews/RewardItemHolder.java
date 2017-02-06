package com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaxfire.james_ash_earthmiles.Model.RewardItem;
import com.jaxfire.james_ash_earthmiles.R;

public class RewardItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name;
    private TextView shortDescription;
    private TextView emCost;
    private TextView realValue;
    private ImageView itemImage;

    public RewardItemHolder(View v) {
        super(v);

        name = (TextView) v.findViewById(R.id.name);
        shortDescription = (TextView) v.findViewById(R.id.short_description);
        emCost = (TextView) v.findViewById(R.id.item_em_cost);
        realValue = (TextView) v.findViewById(R.id.real_world_value);
        itemImage = (ImageView) v.findViewById(R.id.item_image);

        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("jim", "Go to reward page");
        /*Context context = itemView.getContext();
        Intent showPhotoIntent = new Intent(context, PhotoActivity.class);
        //showPhotoIntent.putExtra(PHOTO_KEY, mPhoto);
        context.startActivity(showPhotoIntent);*/
    }

    public void bindRewardItem(RewardItem rewardItem) {

        if (rewardItem.getHasImageLoaded()){
            itemImage.setImageBitmap(rewardItem.getLoadedImage());
        } else{
            //Default not yet loaded image
            itemImage.setImageResource(R.drawable.em_recycler_view_item_loading);
        }

        name.setText(rewardItem.getReward_partner().getName());
        shortDescription.setText(rewardItem.getShort_description());
        emCost.setText(rewardItem.getPoints() + " em");
        realValue.setText(rewardItem.getPound_value_text());

    }

}