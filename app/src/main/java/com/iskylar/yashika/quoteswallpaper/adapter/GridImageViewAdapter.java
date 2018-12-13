package com.iskylar.yashika.quoteswallpaper.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.activity.GridImageViewActivity;
import com.iskylar.yashika.quoteswallpaper.activity.ImageViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yashika on 04-07-2017.
 */

public class GridImageViewAdapter extends RecyclerView.Adapter<GridImageViewAdapter.ViewHolder> {
    private  Context context;
    private int resource;
    private ArrayList<Integer> dataItems;
    private static final String IMAGE_ID="image";
    private static final String POSITION = "Position";

    public GridImageViewAdapter(Context context, int resource, ArrayList<Integer> dataItems) {
        this.context = context;
        this.resource = resource;
        this.dataItems = dataItems;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {

        holder.imageView.setImageResource(dataItems.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageViewActivity.class);
                intent.putIntegerArrayListExtra(IMAGE_ID,dataItems);
                intent.putExtra(POSITION,position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.cat_imagview);
        }
    }
}
