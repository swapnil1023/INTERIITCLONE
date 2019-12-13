package com.example.android.interiit;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SquashFragAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Men", "Women"};
    public SquashFragAdapter(FragmentManager fm){
        super(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new maleSquashFrag();

        else if(position==1)
            return new femaleSquashFrag();

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


