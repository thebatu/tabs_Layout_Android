package com.example.bats.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by bats on 4/20/18.
 *
 */

public class ScreenSlidePageFragment extends Fragment {

    private static final String ARG_RESOURCE_ID = "resource_id";
    private int id; // resource id of the static image to display in this page


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }



    // Your program should call this to create each instance of this Fragment.
    public static ScreenSlidePageFragment newInstance(int id) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_RESOURCE_ID, id);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ARG_RESOURCE_ID);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        // assign our image's resource id here
        ImageView imageView = (ImageView) view.findViewById(R.id.image1);
        imageView.setImageResource(id);
        return view;
    }
























}