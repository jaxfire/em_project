package com.jaxfire.pagerslidingtab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class ActivityRewards extends FragmentActivity{

    private ViewPager mPagerRewards;

    private AdapterRewardsPager mPagerRewardsAdapter;

    private PresenterRewardsPager presenterPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get a reference to the ViewPager
        mPagerRewards = (ViewPager) findViewById(R.id.pager);

        //Instantiate and set the adapter
        mPagerRewardsAdapter = new AdapterRewardsPager(getSupportFragmentManager());
        mPagerRewards.setAdapter(mPagerRewardsAdapter);

        //Create the presenter layer
        presenterPager = new PresenterRewardsPager(this, mPagerRewardsAdapter);

        presenterPager.onPageChanged(mPagerRewards.getCurrentItem());

        //Called when user swipes to a new page
        mPagerRewards.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                presenterPager.onPageChanged(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Not used
            }


            @Override
            public void onPageScrollStateChanged(int state) {
                //Not used
            }

        });

    }

}