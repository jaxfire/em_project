package com.jaxfire.pagerslidingtab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

public class AdapterRewardsPager extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 3;

    public static final String EXTRA_POSITION = "position";

    //Using SparseArray as it is more memory efficient than using a HashMap to map Integers to Objects
    private static SparseArray<FragmentRewardsPager> fragStore = new SparseArray(3);

    //We use newInstance to facilitate the passing of 'position' into the fragment
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
    }

    public AdapterRewardsPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return this.newInstance(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}