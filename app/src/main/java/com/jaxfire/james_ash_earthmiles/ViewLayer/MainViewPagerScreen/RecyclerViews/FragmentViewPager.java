package com.jaxfire.james_ash_earthmiles.ViewLayer.MainViewPagerScreen.RecyclerViews;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaxfire.james_ash_earthmiles.R;

public class FragmentViewPager extends Fragment{

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public AdapterRecyclerView adapter;
    public static final String VIEW_PAGER_POSITION = "position";


    public static FragmentViewPager newInstance(int viewPagerPosition) {

        FragmentViewPager f = new FragmentViewPager();
        Bundle b = new Bundle();
        b.putInt(VIEW_PAGER_POSITION, viewPagerPosition);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        adapter = new AdapterRecyclerView(getArguments().getInt(VIEW_PAGER_POSITION));
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

    }

}