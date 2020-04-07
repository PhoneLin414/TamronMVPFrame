package com.example.tamronmvpframe.base;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder, O> extends RecyclerView.Adapter<T> {

    protected List<O> mData;
    protected LayoutInflater mLayoutInflator;

    int position;
    public BaseRecyclerAdapter(Context context) {

        mData = new ArrayList<>();
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        holder.setData(mData.get(position));
        this.position = position;
    }

    @Override
    public int getItemCount() {
        Log.i("s",mData.size()+"");
        return mData.size();

    }

    public void setNewData(List<O> newData) {
        mData = newData;
        notifyDataSetChanged();

    }

}
