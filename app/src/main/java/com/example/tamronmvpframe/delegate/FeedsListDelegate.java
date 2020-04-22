package com.example.tamronmvpframe.delegate;

import android.widget.ImageView;

public interface FeedsListDelegate {

    void onFeedsTap(int id, String title, String date, String img, ImageView itemImage);

}
