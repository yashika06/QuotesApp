package com.iskylar.yashika.quoteswallpaper.activity;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.iskylar.yashika.quoteswallpaper.Helper.FavouriteDbHelper;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class ImageViewActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    private static final String IMAGE_ID="image";
    ArrayList<Integer> dataList;

    private static final String POSITION = "Position";
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        dataList = getIntent().getIntegerArrayListExtra(IMAGE_ID);
        position = getIntent().getIntExtra(POSITION,0);
        viewPager = (ViewPager) findViewById(R.id.imageViewPager);

        adapter = new ViewPagerAdapter(ImageViewActivity.this,dataList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }

    public void initPagerView(final int position, View view){
        final FavouriteDbHelper helper = new FavouriteDbHelper(ImageViewActivity.this);
        final ImageButton fav_btn = (ImageButton) view.findViewById(R.id.fav_btn);
        fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helper.checkExistence(dataList.get(position))){
                    fav_btn.setImageResource(R.drawable.ic_favorite_border_white_24dp);
                    helper.deleteImage(dataList.get(position));
                }
                else {
                    fav_btn.setImageResource(R.drawable.ic_favorite_white_24dp);
                    helper.insertData(dataList.get(position));
                }

            }
        });
        if(helper.checkExistence(dataList.get(position))) {
            //Toast.makeText(context,"inside if condition: ",Toast.LENGTH_SHORT).show();
            fav_btn.setImageResource(R.drawable.ic_favorite_white_24dp);
        }


    }
}
