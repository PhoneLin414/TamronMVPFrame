package com.example.tamronmvpframe.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tamronmvpframe.R;

public class Utils {

    public static void imageToGlide(String url, ImageView imageView, Context context){

        Glide.with(context).load(url)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground))
                .into(imageView);


    }

}
