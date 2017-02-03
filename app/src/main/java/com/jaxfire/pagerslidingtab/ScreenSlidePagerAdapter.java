package com.jaxfire.pagerslidingtab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.util.SparseArray;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 3;

    public static final String EXTRA_POSITION = "position";

    //Using SparseArray as it is more memory efficient than using a HashMap to map Integers to Objects
    private static SparseArray<ScreenSlidePageFragment> fragStore = new SparseArray(3);

    //We use newInstance to facilitate the passing of 'position' into the fragment
    public static final ScreenSlidePageFragment newInstance(int position)
    {

        if(fragStore.get(position) == null) {
            Log.d("jim", "new fragment created:  Position " + position);
            ScreenSlidePageFragment f = new ScreenSlidePageFragment();
            Bundle bdl = new Bundle(1);
            bdl.putInt(EXTRA_POSITION, position);
            f.setArguments(bdl);
            fragStore.put(position, f);
            return f;
        }
        return fragStore.get(position);
    }

    public ScreenSlidePagerAdapter(FragmentManager fm) {
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

    public void updateFragment(int position, String str){
        fragStore.get(position).updateText(str);
    }
}
