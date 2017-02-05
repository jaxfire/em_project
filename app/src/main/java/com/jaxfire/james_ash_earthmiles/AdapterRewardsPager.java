package com.jaxfire.james_ash_earthmiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

public class AdapterRewardsPager extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;

    public static final String EXTRA_POSITION = "position";

    //Using SparseArray as it is more memory efficient than using a HashMap to map Integers to Objects
    private static SparseArray<FragmentRewardsPager> fragStore = new SparseArray(3);

    public AdapterRewardsPager(FragmentManager fm) {
        super(fm);

        for (int i = 0; i < NUM_PAGES; i++){
            FragmentRewardsPager f = new FragmentRewardsPager();
            Bundle bdl = new Bundle(1);
            bdl.putInt(EXTRA_POSITION, i);
            f.setArguments(bdl);
            fragStore.put(i, f);

        }

    }

    /*//We use newInstance to facilitate the passing of 'position' into the fragment
    public static final FragmentRewardsPager newInstance(int position)
    {

        if(fragStore.get(position) == null) {
            FragmentRewardsPager f = new FragmentRewardsPager();
            Bundle bdl = new Bundle(1);
            bdl.putInt(EXTRA_POSITION, position);
            f.setArguments(bdl);
            fragStore.put(position, f);
            return f;
        }
        return fragStore.get(position);
    }*/

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
        //return this.newInstance(position);
        return fragStore.get(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}