package com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaxfire.james_ash_earthmiles.R;
import com.jaxfire.james_ash_earthmiles.ViewLayer.ViewPager.AdapterViewPager;

public class FragmentViewPager extends Fragment{

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public AdapterRecyclerView adapter;

    private int viewPagerPosition = 0;

    public static FragmentViewPager newInstance(int viewPagerPosition) {

        FragmentViewPager f = new FragmentViewPager();
        Bundle b = new Bundle();
        b.putInt(AdapterViewPager.VIEWPAGERPOSITION, viewPagerPosition);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d("adapter1", "onCreate: " + getArguments().getInt(AdapterViewPager.VIEWPAGERPOSITION));
        adapter = new AdapterRecyclerView(getArguments().getInt(AdapterViewPager.VIEWPAGERPOSITION));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerView.setAdapter(adapter);

        //add the onScrollListener
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int totalItemCount = FragmentViewPager.this.recyclerView.getLayoutManager().getItemCount();
                int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
                if (totalItemCount == lastVisiblePosition + 1) {
                    //Request image instead???
                    //adapter.requestRewardItem(totalItemCount);
                }
            }
        });

        //TODO This needs reworking
        //Initial load of images as buffer
        //adapter.requestRewardItem(0);
        //adapter.requestRewardItem(1);
        //adapter.requestRewardItem(2);
    }
}