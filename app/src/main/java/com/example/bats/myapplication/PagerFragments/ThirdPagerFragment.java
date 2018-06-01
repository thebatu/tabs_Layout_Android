package com.example.bats.myapplication.PagerFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.bats.myapplication.PagerNavigationInterface;

import com.example.bats.myapplication.R;

/**
 * Created by bats on 5/4/18.
 *
 */

public class ThirdPagerFragment extends Fragment {

    /**
     * Fragment to display the 3rd tutorial image
     */

    /**
     * Interface for interacting with buttons on the image xml
     */
    private PagerNavigationInterface pagerNavigationInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.thirdpagerfragment, container, false);
        ImageButton prev = v.findViewById(R.id.btn_previous);
        ImageButton next = v.findViewById(R.id.btn_next);

        prev.setOnClickListener(view -> pagerNavigationInterface.goPrevious());
        next.setOnClickListener(view -> pagerNavigationInterface.goEnd());

        return v;
    }


    /**
     * instantiate a fragment and return it
     * @return  a fragment
     */
    public static ThirdPagerFragment newInstance() {

        ThirdPagerFragment f = new ThirdPagerFragment();
        return f;
    }

    /**
     * set the interface which is implemented in TutorialImagesActivity
     * @param pagerNavigationInterface pagerNavigationInterface
     */
    public void setPagerNavigationInterface(PagerNavigationInterface pagerNavigationInterface){
        this.pagerNavigationInterface = pagerNavigationInterface;
    }



}
