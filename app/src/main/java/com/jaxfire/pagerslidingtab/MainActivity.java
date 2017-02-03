package com.jaxfire.pagerslidingtab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity{

    private ViewPager mPager;

    private ScreenSlidePagerAdapter mPagerAdapter;

    private PagerPresenter pagerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        pagerPresenter = new PagerPresenter(this, mPagerAdapter);

        Button button = (Button) findViewById(R.id.change_frag_values);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagerPresenter != null){
                    pagerPresenter.buttonClicked();
                }
            }
        });

    }

}