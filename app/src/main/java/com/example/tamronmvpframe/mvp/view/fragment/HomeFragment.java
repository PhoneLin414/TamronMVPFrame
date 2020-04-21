package com.example.tamronmvpframe.mvp.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.adapters.FeedsListAdapter;
import com.example.tamronmvpframe.databinding.ActivityFeedDetailBinding;
import com.example.tamronmvpframe.databinding.FragmentHomeBinding;
import com.example.tamronmvpframe.delegate.FeedsListDelegate;
import com.example.tamronmvpframe.mvp.view.activity.FeedDetailActivity;
import com.example.tamronmvpframe.vo.FeedsData;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements FeedsListDelegate {

    private RecyclerView rv_home_feeds;
    private FeedsListAdapter feedsListAdapter;
    private FragmentHomeBinding fragmentHomeBinding;
    List<FeedsData> feedsDataList = new ArrayList<>();
    Toolbar toolbar;
    TextView toolbarTitle,tvHomeTitle;
    AppBarLayout appBarLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        createMockData();
        fragmentHomeBinding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = fragmentHomeBinding.getRoot();
        //toolbar = view.findViewById(R.id.tb_HomeMain);
        toolbarTitle = view.findViewById(R.id.tb_title);
        appBarLayout = view.findViewById(R.id.ab_Main);
        rv_home_feeds = fragmentHomeBinding.rvHomeFeeds;
        tvHomeTitle = view.findViewById(R.id.tv_home_title);

        if (getActivity() != null) {
            feedsListAdapter = new FeedsListAdapter(getActivity(), this,false);
            rv_home_feeds.setAdapter(feedsListAdapter);
            rv_home_feeds.setLayoutManager(new LinearLayoutManager(getActivity()));
            feedsListAdapter.setNewData(feedsDataList);
        }
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                tvHomeTitle.setVisibility(View.VISIBLE);
                toolbarTitle.setVisibility(View.GONE);
                tvHomeTitle.setText("Home");
            } else {

                toolbarTitle.setText("Latest News ");
                toolbarTitle.setTextColor(Color.parseColor("#FFFFFF"));
                toolbarTitle.setVisibility(View.VISIBLE);
                tvHomeTitle.setVisibility(View.GONE);
            }
        });
        return view;

    }

    @Override
    public void onFeedsTap(int id, String title, String date, String img) {

       Intent intent = FeedDetailActivity.intentFromFeedsList(getActivity(),id,title,img);
       startActivity(intent);

    }


    private void createMockData(){

        FeedsData feedsData1 = new FeedsData("Bangladeshis turn to video sites during COVID-19 lockdown","5 April 2020 5:56 GMT","https://globalvoices.org/wp-content/uploads/2020/04/bengalis-1.jpg");
        FeedsData feedsData2 = new FeedsData("Hong Kong government censures public broadcaster for raising question on Taiwan’s WHO membership status","5 April 2020 3:35 GMT ","https://globalvoices.org/wp-content/uploads/2020/04/whob-800x450.jpg");
        FeedsData feedsData3 = new FeedsData("Is India fighting COVID-19 the “mass surveillance” way?","4 April 2020 16:17 GMT","https://globalvoices.org/wp-content/uploads/2020/04/Corona-surveillance-800x450.jpg");
        FeedsData feedsData4 = new FeedsData("COVID-19 diaries from Wuhan: Restrictions tighten","4 April 2020 0:06 GMT","https://globalvoices.org/wp-content/uploads/2020/04/%E5%B0%8F%E5%8D%80%E9%96%80%E5%8F%A3.jpeg");
        FeedsData feedsData5 = new FeedsData("Mozambique and Cape Verde's telcos offer affordable mobile internet as citizens urged to stay home","3 April 2020 23:38 GMT ","https://pt.globalvoices.org/wp-content/uploads/2020/03/Cabo-Verde.jpg");

        feedsDataList.add(feedsData1);
        feedsDataList.add(feedsData2);
        feedsDataList.add(feedsData3);
        feedsDataList.add(feedsData4);
        feedsDataList.add(feedsData5);

    }
}
