package com.example.tamronmvpframe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.base.BaseRecyclerAdapter;
import com.example.tamronmvpframe.base.BaseViewHolder;
import com.example.tamronmvpframe.delegate.FavouriteListDelegate;
import com.example.tamronmvpframe.delegate.FeedsListDelegate;
import com.example.tamronmvpframe.viewholders.FavouriteViewHolder;
import com.example.tamronmvpframe.viewholders.FeedsViewHolder;
import com.example.tamronmvpframe.vo.FavouriteData;

public class FavouriteListAdaper extends BaseRecyclerAdapter<BaseViewHolder, FavouriteData> {

    FavouriteListDelegate favouriteListDelegate;
    Context context;

    public FavouriteListAdaper(Context context,  FavouriteListDelegate favouriteListDelegate) {
        super(context);
        this.favouriteListDelegate = favouriteListDelegate;
        this.context = context;

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflator.inflate(R.layout.item_favourite_cardview,parent,false);

        return new FavouriteViewHolder(context,view,favouriteListDelegate);
    }
}
