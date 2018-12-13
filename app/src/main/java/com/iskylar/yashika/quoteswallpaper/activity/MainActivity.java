package com.iskylar.yashika.quoteswallpaper.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.iskylar.yashika.quoteswallpaper.R;
import com.iskylar.yashika.quoteswallpaper.fragment.DownloadFragment;
import com.iskylar.yashika.quoteswallpaper.fragment.FavouritesFragment;
import com.iskylar.yashika.quoteswallpaper.fragment.GalleryFragment;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    private static int navItemIndex =0;
    private static final String TAG_GALLERY = "Gallery";
    private static final String TAG_FAVOURITES = "Favourite";
    private static final String TAG_DOWNLOAD = "Download";
    public static String CURRENT_TAG = TAG_GALLERY;

    private  int tab_pos=1;
    private String[] activityTitles;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        handler = new Handler();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setUpNavigationView();
        if(savedInstanceState==null){
            navItemIndex = 0;
            CURRENT_TAG=TAG_GALLERY;
            loadHomeFragment();
        }

        if (getIntent()!=null){
            tab_pos = getIntent().getIntExtra("Tab_position_extra",1);
        }

    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_gallery:
                        navItemIndex=0;
                        CURRENT_TAG=TAG_GALLERY;
                        break;
                    case R.id.nav_favourite:
                        navItemIndex=1;
                        CURRENT_TAG=TAG_FAVOURITES;
                        break;
                    case R.id.nav_download:
                        navItemIndex=2;
                        CURRENT_TAG=TAG_DOWNLOAD;
                        break;
                    case R.id.nav_settings:
                        Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_about:
                        Intent intent1 = new Intent(MainActivity.this,AboutUsActivity.class);
                        startActivity(intent1);
                        break;
                    default:
                        navItemIndex=0;
                        break;
                }

                    item.setChecked(true);
                    loadHomeFragment();
                return  true;
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
            return;
        }
        else if(navItemIndex!=0){
            navItemIndex=0;
            CURRENT_TAG=TAG_GALLERY;
            loadHomeFragment();
            return;
        }
        else {
            finish();
        }

    }

    private void loadHomeFragment() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawerLayout.closeDrawers();
            return;
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getHomeFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                transaction.replace(R.id.frame,fragment,CURRENT_TAG);
                transaction.commit();
            }
        };
        if (runnable != null) {
            handler.post(runnable);
        }

        // show or hide the fab button

        //Closing drawer on item click
        drawerLayout.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }
    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                Bundle bun = new Bundle();
                bun.putInt("Tab Position",tab_pos);
                GalleryFragment galleryFragment = new GalleryFragment();
                galleryFragment.setArguments(bun);
                return galleryFragment;
            case 1:
                FavouritesFragment favouritesFragment = new FavouritesFragment();
                return favouritesFragment;
            case 2:
                DownloadFragment downloadFragment = new DownloadFragment();
                return downloadFragment;
            default:
                return new GalleryFragment();
        }
    }
}
