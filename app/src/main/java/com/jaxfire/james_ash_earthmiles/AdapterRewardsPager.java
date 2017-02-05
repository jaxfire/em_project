package com.jaxfire.james_ash_earthmiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

public class AdapterRewardsPager extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;

    public static final String EXTRA_POSITION = "position";

    //Google's Android docs recommend using a SparseArray to map ints to Objects...
    //however Arraylist or Hashmap may be more efficient as there are no gaps in our indexes
    private static SparseArray<FragmentRewardsPager> fragStore = new SparseArray(3);

    public AdapterRewardsPager(FragmentManager fm) {
        super(fm);

        //Instantiate all the required fragments up front
        for (int i = 0; i < NUM_PAGES; i++){
            FragmentRewardsPager fragment = new FragmentRewardsPager();
            //TODO Is the fragment's knowledge of its position still required?
            Bundle bdl = new Bundle(1);
            bdl.putInt(EXTRA_POSITION, i);
            fragment.setArguments(bdl);
            fragStore.put(i, fragment);
        }

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
    public Fragment getItem(int position) { return fragStore.get(position); }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}