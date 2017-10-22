package com.funney.funney_android;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Button;

/**
 * Created by keita on 2017/10/22.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_NUM = 2;

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FeaturedTransactionFragment();
                break;
            case 1:
                fragment = new TransactionHistoryFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
