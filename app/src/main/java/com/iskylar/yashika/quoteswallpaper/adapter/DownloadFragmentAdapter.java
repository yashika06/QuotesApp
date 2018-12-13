package com.iskylar.yashika.quoteswallpaper.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.iskylar.yashika.quoteswallpaper.Model.Image;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.activity.ImageViewActivity;

import java.util.ArrayList;

/**
 * Created by Yashika on 12-07-2017.
 */

public class DownloadFragmentAdapter extends RecyclerView.Adapter<DownloadFragmentAdapter.ViewHolder> {
    private Context context;
    private int resource;
    private ArrayList<Image> datalist;
    private static final String ARRAYLIST="arraylist";
    private static final String POSITION = "Position";
    public DownloadFragmentAdapter(Context context, int resource, ArrayList<Image> datalist) {
        this.context = context;
        this.resource = resource;
        this.datalist = datalist;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imageView.setImageResource(datalist.get(position).getImageRes());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ARRAYLIST,datalist);
                intent.putExtra("BUNDLE",bundle);
                intent.putExtra(POSITION,position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.dwnld_imageview);
        }
    }
}
