package com.example.android.project05_nd_tourguideme;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PlacePagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    //Public constructor for the ViewPager Adapter
    public PlacePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        //Set the Fragments as ViewPager items
        //And else is required!!
        if (position == 0) {
            return new CastlesFragment();
        } else if (position == 1) {
            return new ZOOParksFragment();
        } else if (position == 2) {
            return new CavesFragment();
        } else {
            return new ArchitectureFragment();
        }
    }

    @Override
    public int getCount() {

        //Returns the number of items of the Viewpager
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //Set the titles of the tabs for the TabLayout
        if (position == 0) {
            return mContext.getString(R.string.category_castles);
        } else if (position == 1) {
            return mContext.getString(R.string.category_zoo);
        } else if (position == 2) {
            return mContext.getString(R.string.category_caves);
        } else {
            return mContext.getString(R.string.category_architecture);
        }
    }
}
