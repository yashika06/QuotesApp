package com.iskylar.yashika.quoteswallpaper.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iskylar.yashika.quoteswallpaper.Model.CategoryDataItems;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.activity.GridImageViewActivity;
import com.iskylar.yashika.quoteswallpaper.activity.ImageViewActivity;

import java.util.List;

/**
 * Created by Yashika on 01-07-2017.
 */

public class CategoriesAdapter extends ArrayAdapter<CategoryDataItems>{
    private Context context;
    private int resource;
    List<CategoryDataItems> dataItems;
    private static final String IMAGE_ID="image";
    private static final String POSITION = "Position";

     public CategoriesAdapter(Context context, int resource, List<CategoryDataItems> dataItems) {
        super(context, resource, dataItems);
        this.context=context;
        this.resource=resource;
        this.dataItems=dataItems;
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource,parent,false);
        TextView textView = (TextView) view.findViewById(R.id.categories_textView);
        textView.setText(dataItems.get(position).getCategory_name());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GridImageViewActivity.class);
                intent.putIntegerArrayListExtra("Image array list",dataItems.get(position).getImageRes());
                intent.putExtra("Category Name",dataItems.get(position).getCategory_name());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
