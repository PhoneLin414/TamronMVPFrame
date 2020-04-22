package com.example.tamronmvpframe.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.tamronmvpframe.R;

import static androidx.core.app.ActivityCompat.startPostponedEnterTransition;

public class Utils {

    public static void imageToGlide(String url, ImageView imageView, Context context){

        Glide.with(context).load(url)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground))
//                .listener(new RequestListener<Bitmap>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
//                        imageView.setImageBitmap(resource);
//                        startPostponedEnterTransition();
//                        return true;
//                    }
//                })
                .into(imageView);


    }

}
