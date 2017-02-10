package com.jaxfire.james_ash_earthmiles.ViewLayer.RewardPurchaseScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jaxfire.james_ash_earthmiles.R;

public class ActivityRewardPurchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_purchase);

        Intent intent = getIntent();
        Log.d("jim", "onCreate: " + intent.getStringExtra("name"));
        Log.d("jim", "onCreate: " + intent.getStringExtra("short_description"));
        Log.d("jim", "onCreate: " + intent.getStringExtra("validity"));
        Log.d("jim", "onCreate: " + intent.getStringExtra("availing"));
        Log.d("jim", "onCreate: " + intent.getStringExtra("location"));
        Log.d("jim", "onCreate: " + intent.getStringExtra("timing"));
        Log.d("jim", "onCreate: " + intent.getStringExtra("logo"));
        Log.d("jim", "onCreate: " + intent.getStringExtra("imageURL"));

        this.setTitle(intent.getStringExtra("name"));
    }
}
