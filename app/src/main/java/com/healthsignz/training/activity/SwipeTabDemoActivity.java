package com.healthsignz.training.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.healthsignz.training.R;
import com.healthsignz.training.adapter.MyViewPagerAdapter;
import com.healthsignz.training.fragment.OneFragment;
import com.healthsignz.training.fragment.ThreeFragment;
import com.healthsignz.training.fragment.TwoFragment;

public class SwipeTabDemoActivity extends AppCompatActivity implements OneFragment.TransferOneToTwo{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView mTextViewPlus, mTextViewMinus, mTextViewResult;
    private int count;
    private ListFragment prevFragment;
    MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_swipe_tab_demo);
       // getActionBar().setTitle("swipe");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        mTextViewPlus = (TextView) findViewById(R.id.textView_plus);
        mTextViewMinus = (TextView) findViewById(R.id.textView_minus);
        mTextViewResult = (TextView) findViewById(R.id.textView_result);

        mTextViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewResult.setText(String.valueOf(++count));
                sendData(String.valueOf(count));
            }
        });

        mTextViewMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewResult.setText(String.valueOf(--count));
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_search)
            return true;
        else if (item.getItemId() == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }

     public void sendData(String countValue) {
        OneFragment oneFrag = (OneFragment) adapter.getFragment(viewPager.getCurrentItem());
        oneFrag.changeData(String.valueOf(count));
    }

    @Override
    public void sendOneToTwo(String data) {

    }
}
