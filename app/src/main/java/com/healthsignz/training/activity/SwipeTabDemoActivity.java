package com.healthsignz.training.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.healthsignz.training.R;
import com.healthsignz.training.adapter.MyViewPagerAdapter;
import com.healthsignz.training.fragment.OneFragment;
import com.healthsignz.training.fragment.ThreeFragment;
import com.healthsignz.training.fragment.TwoFragment;

public class SwipeTabDemoActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_tab_demo);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void setUpViewPager(ViewPager viewPager) {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "one");
        adapter.addFragment(new TwoFragment(), "two");
        adapter.addFragment(new ThreeFragment(), "three");
        viewPager.setAdapter(adapter);
    }
}
