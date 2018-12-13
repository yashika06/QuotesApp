package com.iskylar.yashika.quoteswallpaper.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.adapter.GridImageViewAdapter;

import java.util.ArrayList;

public class GridImageViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridImageViewAdapter adapter;
    ArrayList<Integer> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image_view);
        String category_name = getIntent().getStringExtra("Category Name");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(category_name);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_category);
        dataList = getIntent().getIntegerArrayListExtra("Image array list");
        adapter = new GridImageViewAdapter(GridImageViewActivity.this,R.layout.categories_list_items,dataList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
