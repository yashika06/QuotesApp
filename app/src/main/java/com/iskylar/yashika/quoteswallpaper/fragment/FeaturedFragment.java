package com.iskylar.yashika.quoteswallpaper.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.adapter.FeaturedFragmentAdapter;

import java.util.ArrayList;


public class FeaturedFragment extends Fragment {

    RecyclerView recyclerView;
    FeaturedFragmentAdapter adapter;
    ArrayList<Integer> datalist;
    int[] imageRes = new int[]{
            R.drawable.category1_iamge2,
            R.drawable.category2_iamge1,
            R.drawable.category2_iamge4,
            R.drawable.category3_iamge1,
            R.drawable.category4_iamge1,
            R.drawable.category5_iamge3,
    };

    public FeaturedFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_featured, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.featured_recyclerview);
        prepareDataList();
        adapter = new FeaturedFragmentAdapter(getActivity(),R.layout.featured_list_items,datalist);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void prepareDataList(){
        datalist = new ArrayList<>();
        for (int i=0;i<6;i++){
            datalist.add(imageRes[i]);
        }
    }


}
