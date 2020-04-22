package com.example.tamronmvpframe.mvp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.anton46.collectionitempicker.CollectionPicker;
import com.anton46.collectionitempicker.Item;
import com.anton46.collectionitempicker.OnItemClickListener;
import com.example.tamronmvpframe.R;
import com.example.tamronmvpframe.delegate.CollectionPickerDelegate;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
    List<Item> items = new ArrayList<>();
    private TextView toolBarTitle;
   public static CollectionPickerDelegate collectionPickerDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolBarTitle = findViewById(R.id.tv_filterTitle);
        toolBarTitle.setText("Filter");
        myToolbar.setNavigationOnClickListener(v -> onBackPressed());

        items.add(new Item("item", "All"));

        items.add(new Item("item1", "Health and Beauty"));
        items.add(new Item("item2", "Photography"));
        items.add(new Item("item3", "Entertainment"));
        items.add(new Item("item4", "Sports"));
        items.add(new Item("item2", "Internet"));
        items.add(new Item("item2", "Economic"));
        items.add(new Item("item2", "Celebrity"));
        CollectionPicker picker = (CollectionPicker) findViewById(R.id.collection_item_picker);
        picker.setItems(items);
        picker.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(Item item, int position) {
collectionPickerDelegate.onTapCollectionPicker(item.id);
finish();

            }
        });
    }
}

