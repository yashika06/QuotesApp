package com.iskylar.yashika.quoteswallpaper.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.iskylar.yashika.quoteswallpaper.Helper.FavouriteDbHelper;
import com.iskylar.yashika.quoteswallpaper.Model.RecentItems;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.activity.ImageViewActivity;
import com.iskylar.yashika.quoteswallpaper.activity.MainActivity;
import com.iskylar.yashika.quoteswallpaper.fragment.RecentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yashika on 01-07-2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Integer> list;
    ImageView imageView;
    ImageView back_btn;
    ImageButton fav_btn, share_btn, info_btn;
    Button dwnld_btn;


    public ViewPagerAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((FrameLayout)object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {


        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.viewpager_list_items,container,false);
        final FavouriteDbHelper helper = new FavouriteDbHelper(context);
        imageView = (ImageView) view.findViewById(R.id.fullscreen_image);
        back_btn = (ImageView) view.findViewById(R.id.btn_back);
        fav_btn = (ImageButton) view.findViewById(R.id.fav_btn);
        info_btn = (ImageButton) view.findViewById(R.id.info_btn);
        dwnld_btn = (Button) view.findViewById(R.id.btn_dwnld);

        imageView.setImageResource(list.get(position));
        /*back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("Tab_position_extra",1);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });*//*

        fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav_btn.setImageResource(R.drawable.ic_favorite_white_24dp);
                //fav_btn.invalidate();
                helper.insertData(list.get(position));
                Snackbar.make(view,"Image Added to Favourite - "+list.get(position),Snackbar.LENGTH_SHORT).show();
            }
        });
        if(helper.checkExistence(list.get(position))){
            //Toast.makeText(context,"inside if condition: ",Toast.LENGTH_SHORT).show();
            fav_btn.setImageResource(R.drawable.ic_favorite_white_24dp);
        }
        dwnld_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Download button clicked"+position,Snackbar.LENGTH_SHORT).show();
            }
        });*/

        ((ViewPager) container).addView(view);
        ((ImageViewActivity)context).initPagerView(position,view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((FrameLayout) object);

    }
}
