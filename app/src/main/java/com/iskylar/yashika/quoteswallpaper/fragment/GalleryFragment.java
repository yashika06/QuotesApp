package com.iskylar.yashika.quoteswallpaper.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iskylar.yashika.quoteswallpaper.R;


public class GalleryFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int tab_pos;
    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle!=null){
            tab_pos = bundle.getInt("Tab Position",0);
        }
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setTabTitles();
        tabLayout.getTabAt(tab_pos).select();
        return view;
    }

    private void setTabTitles() {
        tabLayout.getTabAt(0).setText("CATEGORIES");
        tabLayout.getTabAt(1).setText("RECENTS");
        tabLayout.getTabAt(2).setText("FEATURED");

    }

    public static class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new CategoriesFragment();
                case 1:
                    return new RecentFragment();
                case 2:
                    return new FeaturedFragment();
                default:
                    return new RecentFragment();
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
