package com.example.tamronmvpframe.viewholders;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.base.BaseViewHolder;
import com.example.tamronmvpframe.delegate.FavouriteListDelegate;
import com.example.tamronmvpframe.utils.Utils;
import com.example.tamronmvpframe.vo.FavouriteData;

public class FavouriteViewHolder extends BaseViewHolder<FavouriteData> {

    Context context;
    private  FavouriteListDelegate favouriteListDelegate;

    public FavouriteViewHolder(Context context, View itemView, FavouriteListDelegate favouriteListDelegate) {
        super(itemView);
        this.favouriteListDelegate = favouriteListDelegate;
        this.context = context;

    }


    @Override
    public void setData(FavouriteData data) {
        LinearLayout favouriteCard = itemView.findViewById(R.id.favourite_card);

        ImageView imageView = itemView.findViewById(R.id.iv_favourite);
        TextView textView = itemView.findViewById(R.id.txt_favourite_title);

        Utils.imageToGlide(data.getImg(),imageView,context);
        textView.setText(data.getTitle());

        favouriteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Data", data.getTitle());
                favouriteListDelegate.onFeedsTap(1,data.getTitle(),data.getDate(),data.getImg(), imageView);
            }
        });

        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

            int devicewidth = displaymetrics.widthPixels;

        favouriteCard.getLayoutParams().width = devicewidth ;


    }
}
