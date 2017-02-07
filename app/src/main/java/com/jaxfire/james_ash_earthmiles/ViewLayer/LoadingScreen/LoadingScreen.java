package com.jaxfire.james_ash_earthmiles.ViewLayer.LoadingScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jaxfire.james_ash_earthmiles.Model.DataModel;
import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.ViewPager.ActivityViewPager;
import com.jaxfire.james_ash_earthmiles.ViewToDataModelContract;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class LoadingScreen extends AppCompatActivity implements ViewToDataModelContract.JSONCallbackHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        // Initialize ImageLoader with custom configuration
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(320, 280) // default = device screen dimensions
                .diskCacheExtraOptions(320, 280, null)
                .tasksProcessingOrder(QueueProcessingType.LIFO) // LIFO is important
                .build();

        // Apply configuration
        ImageLoader.getInstance().init(config);

        //Call initialise and wait for loadJsonCallback
        DataModel.initialise(this);
    }

    public void loadJsonCallback(boolean loadSuccess) {
        if (loadSuccess) {

            Intent intent = new Intent(this, ActivityViewPager.class);
            startActivity(intent);

            //Prevents the back button from returning to this activity
            finish();

        } else {
            //TODO Check internet request to user and try again
            Toast.makeText(this, "Please check your internet connection and try again", Toast.LENGTH_LONG).show();
        }
    }
}
