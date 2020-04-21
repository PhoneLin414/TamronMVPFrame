package com.example.tamronmvpframe.mvp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.adapters.PagerAdapter;
import com.example.tamronmvpframe.mvp.view.fragment.ChannelDetailFragment;
import com.google.android.material.tabs.TabLayout;

public class ChannelDetailActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    TextView mToolbarTitle;
    Toolbar mToolbar;

    public static Intent intentFromChannelList(Context context) {
        Intent intent = new Intent(context, ChannelDetailActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_detail);
        initComponent();
    }


    private void initComponent() {
        mViewPager = findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
        mToolbar = findViewById(R.id.tb_channelDetail);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbarTitle = findViewById(R.id.tv_channelDetailTitle);
        mToolbarTitle.setText("DVB");
        mToolbarTitle.setTextColor(Color.parseColor("#FFFFFF"));

        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ChannelDetailFragment.newInstance(), "Economics");
        adapter.addFragment(ChannelDetailFragment.newInstance(), "Politics");
        adapter.addFragment(ChannelDetailFragment.newInstance(), "Health & Beauty");
        adapter.addFragment(ChannelDetailFragment.newInstance(), "Sports");
        adapter.addFragment(ChannelDetailFragment.newInstance(), "Technology");
        viewPager.setAdapter(adapter);
    }


}
