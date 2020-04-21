package com.example.tamronmvpframe.mvp.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.adapters.CategoryListAdapter;
import com.example.tamronmvpframe.delegate.CategoryListDelegate;
import com.example.tamronmvpframe.vo.CategoryData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryListDelegate {

    private RecyclerView rv_category;
    private CategoryListAdapter categoryListAdapter;

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

        rv_category = view.findViewById(R.id.rv_category);

        if (getActivity() != null) {
            categoryListAdapter = new CategoryListAdapter(getActivity(), this);
            rv_category.setAdapter(categoryListAdapter);
            rv_category.setLayoutManager(new GridLayoutManager(getActivity(),2));

            categoryListAdapter.setNewData(categoryDataList);
        }

        return  view;
    }


    private void createMockData(){

        CategoryData categoryData1 = new CategoryData(0,"Health and Beauty","https://thumbs.dreamstime.com/b/political-news-gold-d-words-dark-digital-background-41801097.jpg");
        CategoryData categoryData2 = new CategoryData(0,"Sports","https://thumbs.dreamstime.com/b/political-news-gold-d-words-dark-digital-background-41801097.jpg");
        CategoryData categoryData3 = new CategoryData(0,"Business & Economic","https://thumbs.dreamstime.com/b/political-news-gold-d-words-dark-digital-background-41801097.jpg");
        CategoryData categoryData4 = new CategoryData(0,"Politic","https://thumbs.dreamstime.com/b/political-news-gold-d-words-dark-digital-background-41801097.jpg");
        CategoryData categoryData5 = new CategoryData(0,"Science","https://thumbs.dreamstime.com/b/political-news-gold-d-words-dark-digital-background-41801097.jpg");

        categoryDataList.add(categoryData1);
        categoryDataList.add(categoryData2);
        categoryDataList.add(categoryData3);
        categoryDataList.add(categoryData4);
        categoryDataList.add(categoryData5);

    }

    @Override
    public void onCategoryTap(int id) {



    }
}
