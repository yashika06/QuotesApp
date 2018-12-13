package com.iskylar.yashika.quoteswallpaper.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iskylar.yashika.quoteswallpaper.Model.RecentItems;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.activity.ImageViewActivity;
import com.iskylar.yashika.quoteswallpaper.activity.RecentImageviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yashika on 30-06-2017.
 */

public class RecentFragmentAdapter extends RecyclerView.Adapter<RecentFragmentAdapter.ViewHolder> {
    private Context context;
    private int resource;
    private ArrayList<Integer> dataList;
    private static final String IMAGE_ID="image";
    private static final String POSITION = "Position";

    public RecentFragmentAdapter(Context context, int resource, ArrayList<Integer> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.imageView.setImageResource(dataList.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageViewActivity.class);
                intent.putIntegerArrayListExtra(IMAGE_ID,dataList);
                intent.putExtra(POSITION,position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imagview_thumbnail);
        }
    }
}
