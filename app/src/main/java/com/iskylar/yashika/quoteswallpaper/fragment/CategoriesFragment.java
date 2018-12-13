package com.iskylar.yashika.quoteswallpaper.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iskylar.yashika.quoteswallpaper.Model.CategoryDataItems;
import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.adapter.CategoriesAdapter;

import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment {


    ListView listView;
    CategoriesAdapter adapter;
    String[] data={"Love Quotes",
    "Just Go Travel Quotes",
    "To My Best Friend Quotes",
    "Be Happy Quotes",
    "Motivational Quotes",
    "Broken Heart Quotes",
    "Christian Quotes",
    "Family Over Everything Quotes",
    "Keep Calm Quotes",
    "Dont Be Afraid Quotes",
    "Having A Soft Heart Quotes",
    "Still Miss U Quotes",
    "Do Not Give Up Quotes",
    "Be Yourself Quotes"};
    public CategoriesFragment() {
        // Required empty public constructor
    }

    List<CategoryDataItems> categoryDataItemses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categories, container, false);

        prepareData();
        listView = (ListView) view.findViewById(R.id.categories_listView);
        adapter = new CategoriesAdapter(getActivity(),R.layout.categories_list_view_item,categoryDataItemses);

        listView.setAdapter(adapter);
        return view;
    }


    private void prepareData(){
        categoryDataItemses = new ArrayList<>();
        ArrayList<Integer> category1 = new ArrayList<>();
        category1.add(R.drawable.category1_image1);
        category1.add(R.drawable.category1_iamge2);
        category1.add(R.drawable.category1_iamge3);
        category1.add(R.drawable.category1_iamge4);
        categoryDataItemses.add(new CategoryDataItems(category1,"Love Quotes"));

        ArrayList<Integer> category2 = new ArrayList<>();
        category2.add(R.drawable.category2_iamge1);
        category2.add(R.drawable.category2_iamge2);
        category2.add(R.drawable.category2_iamge3);
        category2.add(R.drawable.category2_iamge4);
        categoryDataItemses.add(new CategoryDataItems(category2,"Just Go Travel Quotes"));

        ArrayList<Integer> category3 = new ArrayList<>();
        category3.add(R.drawable.category3_iamge1);
        category3.add(R.drawable.category3_iamge2);
        category3.add(R.drawable.category3_iamge3);
        categoryDataItemses.add(new CategoryDataItems(category3,"To My Best Friend Quotes"));

        ArrayList<Integer> category4 = new ArrayList<>();
        category4.add(R.drawable.category4_iamge1);
        category4.add(R.drawable.category4_iamge2);
        category4.add(R.drawable.category4_iamge3);
        category4.add(R.drawable.category4_iamge4);
        categoryDataItemses.add(new CategoryDataItems(category4,"Family Over Everything Quotes"));

        ArrayList<Integer> category5 = new ArrayList<>();
        category5.add(R.drawable.category5_iamge1);
        category5.add(R.drawable.category5_iamge2);
        category5.add(R.drawable.category5_iamge3);
        category5.add(R.drawable.category5_iamge4);
        categoryDataItemses.add(new CategoryDataItems(category5,"Broken Heart Quotes"));



    }

}
