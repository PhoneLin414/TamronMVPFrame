package com.example.tamronmvpframe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.base.BaseRecyclerAdapter;
import com.example.tamronmvpframe.base.BaseViewHolder;
import com.example.tamronmvpframe.delegate.CategoryListDelegate;
import com.example.tamronmvpframe.viewholders.CategoryViewHolder;
import com.example.tamronmvpframe.vo.CategoryData;

public class CategoryListAdapter extends BaseRecyclerAdapter<BaseViewHolder, CategoryData> {

    CategoryListDelegate categoryListDelegate;
    Context context;

    public CategoryListAdapter(Context context,CategoryListDelegate categoryListDelegate) {
        super(context);
        this.context = context;
        this.categoryListDelegate = categoryListDelegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflator.inflate(R.layout.item_category_cardview,parent,false);

        return new CategoryViewHolder(context,view,categoryListDelegate);


    }

}
