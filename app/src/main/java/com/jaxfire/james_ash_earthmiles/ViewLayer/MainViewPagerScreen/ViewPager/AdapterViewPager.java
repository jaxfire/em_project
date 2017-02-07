package com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.ViewPager;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.RecyclerViews.FragmentViewPager;

public class AdapterViewPager extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;
    public static final String VIEW_PAGER_POSITION = "position";

    public AdapterViewPager(FragmentManager fm) {
        super(fm);

    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title = "";

        switch (position){
            case 0:
                title = "Nutrition";
                break;
            case 1:
                title = "Fitness";
                break;
            case 2:
                title = "Wellness";
                break;
        }

        return title;
    }

    @Override
    public Fragment getItem(int position) {

        Log.d("adapter1", "getItem: " + position);
        return FragmentViewPager.newInstance(position);

    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}