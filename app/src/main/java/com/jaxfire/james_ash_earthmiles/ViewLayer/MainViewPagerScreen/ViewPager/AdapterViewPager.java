package com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jaxfire.james_ash_earthmiles.Categories;
import com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.RecyclerViews.FragmentViewPager;

public class AdapterViewPager extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title = "";

        switch (position){
            case 0:
                title = Categories.NUTRITION.toString();
                break;
            case 1:
                title = Categories.FITNESS.toString();
                break;
            case 2:
                title = Categories.WELLNESS.toString();
                break;
        }

        return title;
    }

    @Override
    public Fragment getItem(int position) {

        return FragmentViewPager.newInstance(position);

    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}