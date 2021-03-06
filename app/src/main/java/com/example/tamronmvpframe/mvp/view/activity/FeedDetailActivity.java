package com.example.tamronmvpframe.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.tamronmvpframe.adapters.FeedsListAdapter;
import com.example.tamronmvpframe.delegate.FeedsListDelegate;
import com.example.tamronmvpframe.utils.Utils;
import com.example.tamronmvpframe.vo.FeedsData;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tamronmvpframe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FeedDetailActivity extends AppCompatActivity implements FeedsListDelegate {

    TextView txt_detail_title, toolbar_title;
    ImageView img_FeedDtail;
    RecyclerView rv_detail_relatednews;
    FeedsListAdapter feedsListAdapter;
    AppBarLayout appBarLayout;
    Toolbar toolbar;

    List<FeedsData> feedsDataList = new ArrayList<>();

    Menu menu;
    Boolean isFavourite = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        toolbar_title = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        createMockData();


        initUI();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {


                if (verticalOffset == 0) {
                    toolbar_title.setVisibility(View.GONE);
                } else {
                    toolbar_title.setText("Title ");
                    toolbar_title.setVisibility(View.VISIBLE);
                }
            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feed_detail, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bookmark:

                if (isFavourite) {
                    isFavourite = false;
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.home));
                } else {
                    isFavourite = true;
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.bookmark));
                }

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static Intent intentFromFeedsList(Context context, int id, String title, String img) {

        Intent intent = new Intent(context, FeedDetailActivity.class);
        Bundle bd = new Bundle();
        bd.putInt("ID", id);
        bd.putString("TITLE", title);
        bd.putString("IMG", img);
        intent.putExtras(bd);
        return intent;
    }


    private void initUI() {

        txt_detail_title = findViewById(R.id.txt_detail_title);
        img_FeedDtail = findViewById(R.id.img_feeddetail);
        rv_detail_relatednews = findViewById(R.id.rv_detail_relatednews);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bd = getIntent().getExtras();

            Utils.imageToGlide(bd.getString("IMG"), img_FeedDtail, this);
            txt_detail_title.setText(bd.getString("TITLE"));
        }

        feedsListAdapter = new FeedsListAdapter(this, this, true);
        rv_detail_relatednews.setAdapter(feedsListAdapter);
        rv_detail_relatednews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        feedsListAdapter.setNewData(feedsDataList);


    }

    @Override
    public void onFeedsTap(int id, String title, String date, String img) {

    }


    private void createMockData() {

        FeedsData feedsData1 = new FeedsData("Bangladeshis turn to video sites during COVID-19 lockdown", "5 April 2020 5:56 GMT", "https://globalvoices.org/wp-content/uploads/2020/04/bengalis-1.jpg");
        FeedsData feedsData2 = new FeedsData("Hong Kong government censures public broadcaster for raising question on Taiwan’s WHO membership status", "5 April 2020 3:35 GMT ", "https://globalvoices.org/wp-content/uploads/2020/04/whob-800x450.jpg");
        FeedsData feedsData3 = new FeedsData("Is India fighting COVID-19 the “mass surveillance” way?", "4 April 2020 16:17 GMT", "https://globalvoices.org/wp-content/uploads/2020/04/Corona-surveillance-800x450.jpg");
        FeedsData feedsData4 = new FeedsData("COVID-19 diaries from Wuhan: Restrictions tighten", "4 April 2020 0:06 GMT", "https://globalvoices.org/wp-content/uploads/2020/04/%E5%B0%8F%E5%8D%80%E9%96%80%E5%8F%A3.jpeg");
        FeedsData feedsData5 = new FeedsData("Mozambique and Cape Verde's telcos offer affordable mobile internet as citizens urged to stay home", "3 April 2020 23:38 GMT ", "https://pt.globalvoices.org/wp-content/uploads/2020/03/Cabo-Verde.jpg");

        feedsDataList.add(feedsData1);
        feedsDataList.add(feedsData2);
        feedsDataList.add(feedsData3);
        feedsDataList.add(feedsData4);
        feedsDataList.add(feedsData5);

    }
}
