package com.example.android.interiit;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class fragAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Male", "Female"};
    public fragAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new maleVolleyballFrag();

        else if(position==1)
            return new femaleVolleyballFrag();

        return null;
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

