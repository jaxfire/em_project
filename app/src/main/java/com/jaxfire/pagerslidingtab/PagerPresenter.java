package com.jaxfire.pagerslidingtab;

import android.util.Log;

public class PagerPresenter {

    MainActivity mainActivity;
    ScreenSlidePagerAdapter adapter;

    public PagerPresenter(MainActivity mainActivity, ScreenSlidePagerAdapter adapter){
        this.mainActivity = mainActivity;
        this.adapter = adapter;
    }

    public void buttonClicked(){
        Log.d("jim", "buttonClicked: ");
        adapter.updateFragment(0, "update");
    }


}
