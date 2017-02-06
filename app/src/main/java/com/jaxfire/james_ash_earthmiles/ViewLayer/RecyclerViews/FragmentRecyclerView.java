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
    private DataModel dataModel;

    public static final String EXTRA_POSITION = "position";

    //TODO os this required anymore?
    private int position;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(EXTRA_POSITION);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AdapterRecyclerView();
        recyclerView.setAdapter(adapter);

        //TODO Use Dependency Injection to enable mocking of data layer
        dataModel = DataModel.getInstance(position, adapter);

        //add the onScrollListener
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int totalItemCount = FragmentRecyclerView.this.recyclerView.getLayoutManager().getItemCount();
                int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
                if (totalItemCount == lastVisiblePosition + 1) {
                        dataModel.requestRewardItem(position);
                }
            }
        });

        //TODO Query the cache
        //if (rewardItems.size() == 0) {
        if(true){
            dataModel.requestRewardItem(position);
            dataModel.requestRewardItem(position);
        }

        return rootView;
    }

}