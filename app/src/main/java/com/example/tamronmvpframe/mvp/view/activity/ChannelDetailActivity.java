package com.example.tamronmvpframe.mvp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.tamronmvpframe.R;

public class ChannelDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_detail);
    }

    public static Intent intentFromChannelList(Context context) {

        Intent intent = new Intent(context, ChannelDetailActivity.class);

        return intent;
    }
}
