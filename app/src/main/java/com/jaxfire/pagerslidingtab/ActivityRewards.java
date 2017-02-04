package com.jaxfire.pagerslidingtab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import static com.jaxfire.pagerslidingtab.R.id.pager;

public class ActivityRewards extends FragmentActivity {

    private ViewPager mPagerRewards;

    private AdapterRewardsPager mPagerRewardsAdapter;

    private PresenterRewardsPager presenterPager;

    private ArrayList<TextView> tabScrollerTitles;

    PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get a reference to the ViewPager
        mPagerRewards = (ViewPager) findViewById(pager);

        //Instantiate and set the adapter
        mPagerRewardsAdapter = new AdapterRewardsPager(getSupportFragmentManager());
        mPagerRewards.setAdapter(mPagerRewardsAdapter);

        // Bind the tabScroller to the ViewPager
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setUnderlineColorResource(R.color.tabs_light_grey);
        tabs.setDividerColor(R.color.tabs_light_grey);
        tabs.setUnderlineHeight(2);
        tabs.setIndicatorColorResource(R.color.tabs_indicator);
        tabs.setIndicatorHeight(3);
        tabs.setShouldExpand(true);//TODO Test setShouldExpand() on larger devices
        tabs.setAllCaps(false);
        tabs.setTabPaddingLeftRight(18);
        tabs.setViewPager(mPagerRewards);

        //Get references to the TextViews inside the tabScroller
        LinearLayout tabsLayout = (LinearLayout) tabs.getChildAt(0);
        tabScrollerTitles = new ArrayList<>(3);
        for(int i = 0; i < 3; i++) {
            TextView temp = (TextView) tabsLayout.getChildAt(i);
            temp.setTextSize(temp.getTextSize()); // No idea why this works! but it works
            tabScrollerTitles.add(temp);
        }

        styleTitles(0);

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

    public void styleTitles(int position){

        //Make the currently selected title a darker shade of grey and the others a lighter grey
        for (int i = 0; i < 3; i++){
            if (i == position){
                tabScrollerTitles.get(i).setTextColor(ContextCompat.getColor(this, R.color.tabs_dark_grey));
            } else {
                tabScrollerTitles.get(i).setTextColor(ContextCompat.getColor(this, R.color.tabs_light_grey));
            }
        }
    }

}