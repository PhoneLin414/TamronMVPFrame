package com.example.tamronmvpframe.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.base.BaseViewHolder;
import com.example.tamronmvpframe.delegate.CategoryListDelegate;
import com.example.tamronmvpframe.utils.Utils;
import com.example.tamronmvpframe.vo.CategoryData;

public class CategoryViewHolder extends BaseViewHolder<CategoryData> {

    CategoryListDelegate categoryListDelegate;
    Context context;

    public CategoryViewHolder(Context context,View itemView, CategoryListDelegate categoryListDelegate) {
        super(itemView);
        this.categoryListDelegate = categoryListDelegate;
        this.context = context;
    }

    @Override
    public void setData(CategoryData data) {

        LinearLayout categorycard= itemView.findViewById(R.id.categorycard);
        ImageView img_category = itemView.findViewById(R.id.iv_channelLogo);
        TextView txt_categoryName = itemView.findViewById(R.id.tv_channelname);

        Utils.imageToGlide(data.getCategoryimg(),img_category,context);

        txt_categoryName.setText(data.getCategoryName());

        categorycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryListDelegate.onCategoryTap(data.getId());
            }
        });

    }
}
