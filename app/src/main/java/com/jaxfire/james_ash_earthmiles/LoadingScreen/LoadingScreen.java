package com.jaxfire.james_ash_earthmiles.LoadingScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jaxfire.james_ash_earthmiles.Model.DataModel;
import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.ViewLayer.ViewPager.ActivityViewPager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        // Initialize ImageLoader with configuration.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
        ImageLoader.getInstance().init(config.build());

        //Call initialise and wait for loadJsonCallback
        DataModel.initialise(this, ImageLoader.getInstance());
    }

    public void loadJsonCallback(boolean loadSuccess){
        if (loadSuccess){
            Log.d("jim", "The json loaded successfully");
            //Intent to main activity
            Intent intent = new Intent(this, ActivityViewPager.class);
            startActivity(intent);

            //Prevent the back button from returning to the loading screen
            finish();

        }else{
            //TODO Make this pass on a failed message to the ActivityViewPager
            Toast.makeText(this, "Failed to load the json", Toast.LENGTH_LONG).show();
        }
    }
}
