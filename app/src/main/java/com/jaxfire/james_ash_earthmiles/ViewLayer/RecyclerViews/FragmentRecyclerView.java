package com.jaxfire.james_ash_earthmiles.ViewLayer.RecyclerViews;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaxfire.james_ash_earthmiles.Model.DataModel;
import com.jaxfire.james_ash_earthmiles.R;

public class FragmentRecyclerView extends Fragment{

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AdapterRecyclerView adapter;


    public static final String EXTRA_POSITION = "viewPagerPosition";

    //TODO os this required anymore?
    private int viewPagerPosition;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        viewPagerPosition = getArguments().getInt(EXTRA_POSITION);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AdapterRecyclerView(viewPagerPosition);
        recyclerView.setAdapter(adapter);

        //add the onScrollListener
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int totalItemCount = FragmentRecyclerView.this.recyclerView.getLayoutManager().getItemCount();
                int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
                if (totalItemCount == lastVisiblePosition + 1) {
                    adapter.requestRewardItem(totalItemCount);
                }
            }
        });

        //TODO This needs reworking
        //Initial load of images as buffer
        adapter.requestRewardItem(0);
        adapter.requestRewardItem(1);
        adapter.requestRewardItem(2);

        return rootView;
    }

}