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
import android.widget.Toast;

import com.iskylar.yashika.quoteswallpaper.Helper.FavouriteDbHelper;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.adapter.FavouriteFragmentAdapter;

import java.util.ArrayList;


public class FavouritesFragment extends Fragment {
    RecyclerView recyclerView;
    FavouriteFragmentAdapter adapter;


    public FavouritesFragment() {
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
        View view= inflater.inflate(R.layout.fragment_favourites, container, false);
        FavouriteDbHelper helper = new FavouriteDbHelper(getActivity());
        ArrayList<Integer> datalist = helper.retrieveData();
        if (datalist.size()>0) {
            recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_favourite);
            adapter = new FavouriteFragmentAdapter(getActivity(), R.layout.favourite_list_item, datalist);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
        else
        {
            Toast.makeText(getActivity(),"No quotes addded as favourite",Toast.LENGTH_LONG).show();
        }
        return view;
    }

}
