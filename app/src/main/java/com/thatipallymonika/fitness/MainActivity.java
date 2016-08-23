package com.thatipallymonika.fitness;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Metric"),
                com.thatipallymonika.fitness.Tab1Fragment.class, null);


        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("US"),
                com.thatipallymonika.fitness.Tab2Fragment.class, null);


        // mTabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.tabc);

        setTabColor(mTabHost);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String arg0) {

                setTabColor(mTabHost);
            }
        });




    }
    public static void setTabColor(TabHost tabhost) {

        for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
            tabhost.getTabWidget().getChildAt(i)
                    .setBackgroundColor(Color.WHITE);

        }
        tabhost.getTabWidget().setCurrentTab(0);
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab())
                .setBackgroundColor(Color.BLUE);
        for (int i = 1; i < tabhost.getTabWidget().getChildCount(); i++) {
            tabhost.getTabWidget().getChildAt(i)
                    .setBackgroundColor(Color.WHITE);

        }
        tabhost.getTabWidget().setCurrentTab(1);
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab())
                .setBackgroundColor(Color.BLUE);
    }
}
