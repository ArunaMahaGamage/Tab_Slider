package com.example.aruna.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by aruna on 2/18/18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    List<String> imageURLlist;

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fragmentManager, int numberOfTabs, List <String> imageURLlist) {
        super(fragmentManager);

        this.mNoOfTabs = numberOfTabs;
        this.imageURLlist = imageURLlist;
    }
    @Override
    public Fragment getItem(int position) {
        Tab1 tab1 = new Tab1();
        return tab1;
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
