package com.example.bats.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.bats.myapplication.PagerFragments.FirstPagerFragment;
import com.example.bats.myapplication.PagerFragments.SecondPagerFragment;
import com.example.bats.myapplication.PagerFragments.ThirdPagerFragment;


/**
 * Created by bats on 4/20/18.
 *
 */

public class ScreenSlidePagerActivity extends FragmentActivity implements PagerNavigationInterface  {

    private static final int[] IMAGES = {R.drawable.tut_img_1, R.drawable.tut_img_2, R.drawable.tut_img_3, R.drawable.tut_img_4};




    /**
     * The number of pages (wizard steps) to show in this demo.
     */

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


    @Override
    public void goNext() {
        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
    }


    @Override
    public void goPrevious() {
        mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    }


    @Override
    public void goEnd() {
            finish();

    }
    private class myPagerAdapter extends FragmentPagerAdapter {

        public myPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            FirstPagerFragment firstFragment = FirstPagerFragment.newInstance();
            firstFragment.setPagerNavigationInterface(ScreenSlidePagerActivity.this);

            SecondPagerFragment secondFragment = SecondPagerFragment.newInstance();
            secondFragment.setPagerNavigationInterface(ScreenSlidePagerActivity.this);

            ThirdPagerFragment thirdFragment= ThirdPagerFragment.newInstance();
            thirdFragment.setPagerNavigationInterface(ScreenSlidePagerActivity.this);

            switch (position) {
                case 0:
                    return firstFragment;
                case 1:
                    return secondFragment;
                default:
                    return thirdFragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}

