package com.example.aruna.tabs;

import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SliderActivity extends AppCompatActivity implements Slider.OnFragmentInteractionListener {

    TabLayout tabLayout;
    List <String> imageURLlist = new ArrayList<>();
    Handler handler;
    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        imageURLlist.add("Tab 1");
        imageURLlist.add("Tab 2");
        imageURLlist.add("Tab 3");
        imageURLlist.add("Tab 4");
        imageURLlist.add("Tab 5");
        imageURLlist.add("Tab 6");
        imageURLlist.add("Tab 7");
        imageURLlist.add("Tab 8");
        imageURLlist.add("Tab 9");
        imageURLlist.add("Tab 10");


        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        for (int i = 0; i < imageURLlist.size(); i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),imageURLlist);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                viewPager.setCurrentItem(value);
                handler.postDelayed(this, 1000);
                value++;
                if (value == imageURLlist.size()) {
                    value = 0;
                }
            }
        };

        handler.postDelayed(r, 1000);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
