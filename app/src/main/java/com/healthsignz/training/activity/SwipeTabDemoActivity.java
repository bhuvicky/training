package com.healthsignz.training.activity;

import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.healthsignz.training.Communicator;
import com.healthsignz.training.R;
import com.healthsignz.training.adapter.MyViewPagerAdapter;
import com.healthsignz.training.fragment.OneFragment;
import com.healthsignz.training.fragment.ThreeFragment;
import com.healthsignz.training.fragment.TwoFragment;

import static com.healthsignz.training.R.id.textView_Result;

public class SwipeTabDemoActivity extends AppCompatActivity implements Communicator{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView mTextViewPlus, mTextViewMinus, mTextViewResult;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_tab_demo);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        mTextViewPlus = (TextView) findViewById(R.id.textView_plus);
        mTextViewMinus = (TextView) findViewById(R.id.textView_minus);
        mTextViewResult = (TextView) findViewById(R.id.textView_result);

        mTextViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewResult.setText(String.valueOf(++count));
                OneFragment prevFragment = (OneFragment) getSupportFragmentManager().findFragmentByTag("prev");
                prevFragment.changeData(String.valueOf(count));
            }
        });

        mTextViewMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewResult.setText(String.valueOf(--count));
            }
        });
    }

    public void setUpViewPager(ViewPager viewPager) {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Prev");
        adapter.addFragment(new TwoFragment(), "Present");
        adapter.addFragment(new ThreeFragment(), "Next");
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



    @Override
    public void sendData(String countValue) {

    }
}
