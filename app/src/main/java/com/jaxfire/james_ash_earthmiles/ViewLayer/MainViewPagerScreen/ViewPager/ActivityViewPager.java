package com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.ViewPager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.jaxfire.james_ash_earthmiles.R;

import java.util.ArrayList;

public class ActivityViewPager extends FragmentActivity{

    private ViewPager mPagerRewards;

    private AdapterViewPager mPagerRewardsAdapter;

    private ArrayList<TextView> tabScrollerTitles;

    PagerSlidingTabStrip tabs;

    Animation textGrow, textShrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        //Get references
        textGrow = AnimationUtils.loadAnimation(this, R.anim.animation_text_scale_grow);
        textShrink = AnimationUtils.loadAnimation(this, R.anim.animation_text_scale_shrink);
        mPagerRewards = (ViewPager) findViewById(R.id.pager);

        //Instantiate and set the ViewPager's adapter
        mPagerRewardsAdapter = new AdapterViewPager(getSupportFragmentManager());
        mPagerRewards.setAdapter(mPagerRewardsAdapter);

        //Called when user swipes to a new page
        mPagerRewards.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                styleTitles(position);
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

        // Customise and bind the pagerslidingtabstrip to the ViewPager
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setUnderlineColorResource(R.color.tabs_light_grey);
        tabs.setDividerColor(R.color.tabs_light_grey);
        tabs.setUnderlineHeight(2);
        tabs.setIndicatorColorResource(R.color.tabs_indicator);
        tabs.setIndicatorHeight(3);
        tabs.setShouldExpand(true);
        tabs.setAllCaps(false);
        tabs.setTabPaddingLeftRight(18);
        tabs.setViewPager(mPagerRewards);

        //Get references to the TextViews inside the tabScroller
        LinearLayout tabsLayout = (LinearLayout) tabs.getChildAt(0);
        tabScrollerTitles = new ArrayList<>(3);

        //Larger devices should have a larger text size
        int textSize = 18; //Default for all other devices
        if(getResources().getBoolean(R.bool.isTablet)) {
            textSize = 30;
        }
        for(int i = 0; i < 3; i++) {
            TextView temp = (TextView) tabsLayout.getChildAt(i);
            temp.setTextSize(textSize);
            tabScrollerTitles.add(temp);
        }

        styleTitles(0);



    }//End onCreate

    public void styleTitles(int position){

        for (int i = 0; i < 3; i++){

            if (i == position){

                //Make the currently selected title a darker shade of grey
                final TextView selectedTitle = tabScrollerTitles.get(i);
                selectedTitle.setTextColor(ContextCompat.getColor(this, R.color.tabs_dark_grey));

                //and run its animation
                textGrow.reset();
                textShrink.reset();
                selectedTitle.clearAnimation();
                selectedTitle.startAnimation(textGrow);

                textGrow.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        selectedTitle.startAnimation(textShrink);
                    }

                    @Override
                    public void onAnimationStart(Animation animation) {//Not used
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //na
                    }

                });


            } else {

                //Reset the unselected titles to a light grey
                tabScrollerTitles.get(i).setTextColor(ContextCompat.getColor(this, R.color.tabs_light_grey));

            }
        }

    } //End styleTitles

}