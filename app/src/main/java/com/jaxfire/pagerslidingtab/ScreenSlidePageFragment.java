package com.jaxfire.pagerslidingtab;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScreenSlidePageFragment extends Fragment{

    public static final String EXTRA_POSITION = "position";

    private int position;

    TextView idText;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(EXTRA_POSITION);
        Log.d("jim", "onCreate: ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        Log.d("jim", "onCreateView: ");
        idText = (TextView) rootView.findViewById(R.id.frag_text);
        updateText(String.valueOf(position));
        return rootView;
    }

    public void updateText(String str){
        idText.setText(str);
    }

}
