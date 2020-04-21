package com.example.tamronmvpframe.viewholders;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.base.BaseViewHolder;
import com.example.tamronmvpframe.delegate.FeedsListDelegate;
import com.example.tamronmvpframe.utils.Utils;
import com.example.tamronmvpframe.vo.FeedsData;

public class FeedsViewHolder extends BaseViewHolder<FeedsData> {

    Context context;


    private FeedsListDelegate feedsListDelegate;
    Boolean isRelatedNews;

    public FeedsViewHolder(Context context, View itemView, FeedsListDelegate feedsListDelegate,Boolean isRelatedNews) {
        super(itemView);
        this.feedsListDelegate = feedsListDelegate;
        this.context = context;
        this.isRelatedNews = isRelatedNews;
    }

    @Override
    public void setData(FeedsData data) {

        LinearLayout feedscard = itemView.findViewById(R.id.feedscard);

        ImageView imageView = itemView.findViewById(R.id.iv);
        TextView textView = itemView.findViewById(R.id.txt_feeds_title);

        Utils.imageToGlide(data.getImg(),imageView,context);
        textView.setText(data.getTitle());

        feedscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedsListDelegate.onFeedsTap(1,data.getTitle(),data.getDate(),data.getImg());
            }
        });

        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        if (isRelatedNews){

            //if you need three fix imageview in width
            int devicewidth = displaymetrics.widthPixels - displaymetrics.widthPixels/5;

            feedscard.getLayoutParams().width = devicewidth;
        }else {
            int devicewidth = displaymetrics.widthPixels;

            feedscard.getLayoutParams().width = devicewidth ;
        }
//
//


    }


}
