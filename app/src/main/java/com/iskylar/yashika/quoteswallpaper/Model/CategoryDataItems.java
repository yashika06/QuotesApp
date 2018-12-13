package com.iskylar.yashika.quoteswallpaper.Model;

import java.util.ArrayList;

/**
 * Created by Yashika on 01-07-2017.
 */

public class CategoryDataItems {
    String category_name;
    ArrayList<Integer> imageRes;

    public CategoryDataItems(ArrayList<Integer> imageRes, String category_name) {
        this.imageRes = imageRes;
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public ArrayList<Integer> getImageRes() {
        return imageRes;
    }

    public void setImageRes(ArrayList<Integer> imageRes) {
        this.imageRes = imageRes;
    }
}
