package com.example.android.interiit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Volleyball extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball);

        ViewPager viewPager = findViewById(R.id.VolleyballPager);
        fragAdapter adapter = new fragAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout=findViewById(R.id.sliding_tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        }
    }

