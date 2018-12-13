package com.iskylar.yashika.quoteswallpaper.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iskylar.yashika.quoteswallpaper.Model.RecentItems;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.adapter.RecentFragmentAdapter;

import java.util.ArrayList;
import java.util.List;


public class RecentFragment extends Fragment {
    RecyclerView recyclerView;
    RecentFragmentAdapter adapter;
    ArrayList<Integer> dataList;
    int[] covers = new int[]{
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.album1,
            R.drawable.album2,
            R.drawable.album3,
            };
    public RecentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recent, container, false);
        prepareList();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_recent);
        adapter = new RecentFragmentAdapter(getActivity(),R.layout.recent_list_items,dataList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        //  recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void prepareList(){
        dataList = new ArrayList<>();
        for (int i=0;i<6;i++){
            dataList.add(covers[i]);
        }
    }

}
