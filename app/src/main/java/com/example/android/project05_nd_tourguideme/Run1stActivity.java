package com.example.android.project05_nd_tourguideme;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Run1stActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run1st_layout);

        //Create the viewpager
        ViewPager viewPager = findViewById(R.id.viewPager);

        //Set the adapter for the viewpager
        PlacePagerAdapter adapter = new PlacePagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        //Set the TabLayout for the ViewPager
        TabLayout tabs = findViewById(R.id.tab);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
