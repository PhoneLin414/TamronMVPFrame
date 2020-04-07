package com.example.tamronmvpframe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.base.BaseRecyclerAdapter;
import com.example.tamronmvpframe.base.BaseViewHolder;
import com.example.tamronmvpframe.delegate.FeedsListDelegate;
import com.example.tamronmvpframe.viewholders.FeedsViewHolder;
import com.example.tamronmvpframe.vo.FeedsData;

public class FeedsListAdapter extends BaseRecyclerAdapter<BaseViewHolder, FeedsData> {

    FeedsListDelegate feedsListDelegate;
    Context context;
    Boolean isRelatedNews;

    public FeedsListAdapter(Context context, FeedsListDelegate feedsListDelegate,Boolean isRelatedNews) {
        super(context);
        this.feedsListDelegate = feedsListDelegate;
        this.context = context;
        this.isRelatedNews = isRelatedNews;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflator.inflate(R.layout.feeds_cardview,parent,false);

        return new FeedsViewHolder(context,view,feedsListDelegate,isRelatedNews);
    }
}
