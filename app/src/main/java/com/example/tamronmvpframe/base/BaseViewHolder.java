package com.example.tamronmvpframe.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


public abstract class BaseViewHolder<O> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(O data);

}


