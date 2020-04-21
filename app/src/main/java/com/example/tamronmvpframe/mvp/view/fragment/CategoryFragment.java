package com.example.tamronmvpframe.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.adapters.CategoryListAdapter;
import com.example.tamronmvpframe.delegate.CategoryListDelegate;
import com.example.tamronmvpframe.mvp.view.activity.ChannelDetailActivity;
import com.example.tamronmvpframe.vo.CategoryData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryListDelegate {

    private RecyclerView rv_category;
    private CategoryListAdapter categoryListAdapter;
    private TextView tv_categoryTitle;
    List<CategoryData> categoryDataList = new ArrayList<>();

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        createMockData();

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        tv_categoryTitle = view.findViewById(R.id.tv_categoryTitle);
        rv_category = view.findViewById(R.id.rv_category);
        tv_categoryTitle.setText("Category");
        if (getActivity() != null) {
            categoryListAdapter = new CategoryListAdapter(getActivity(), this);
            rv_category.setAdapter(categoryListAdapter);
            rv_category.setLayoutManager(new LinearLayoutManager(getActivity()));

            categoryListAdapter.setNewData(categoryDataList);
        }

        return  view;
    }


    private void createMockData(){

        CategoryData categoryData1 = new CategoryData(0,"Mizzima","https://upload.wikimedia.org/wikipedia/my/thumb/8/8e/Logo_of_Mizzima_Daily.svg/1024px-Logo_of_Mizzima_Daily.svg.png");
        CategoryData categoryData2 = new CategoryData(0,"The Irrawaddy","https://www.irrawaddy.com/wp-content/themes/irrawaddy-mobile/images/logo-og.png");
        CategoryData categoryData3 = new CategoryData(0,"adc","https://lh3.googleusercontent.com/3J9u7BjkDXEPrh_VjAAsdCWoJ6v8AUQZjP2OyHIAapR_kf9cIrk_dP8eD3XBd5JqkA");


        categoryDataList.add(categoryData1);
        categoryDataList.add(categoryData2);
        categoryDataList.add(categoryData3);

    }

    @Override
    public void onCategoryTap(int id) {
        Intent intent = ChannelDetailActivity.intentFromChannelList(getActivity());
        startActivity(intent);


    }
}
