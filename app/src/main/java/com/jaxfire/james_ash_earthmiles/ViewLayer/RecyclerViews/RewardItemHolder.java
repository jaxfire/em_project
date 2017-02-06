package com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaxfire.james_ash_earthmiles.R;

public class RewardItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView itemCompany;
    private TextView itemDescription;
    private ImageView itemImage;

    public RewardItemHolder(View v) {
        super(v);

        itemCompany = (TextView) v.findViewById(R.id.item_company);
        itemDescription = (TextView) v.findViewById(R.id.item_description);
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
        //mPhoto = photo;
        //Picasso.with(mItemImage.getContext()).load(photo.getUrl()).into(mItemImage);
        itemImage.setImageResource(R.drawable.em_test_image);
        //itemCompany.setText(rewardItem.getCompanyName());
        //itemDescription.setText(rewardItem.getDescription());
    }

}