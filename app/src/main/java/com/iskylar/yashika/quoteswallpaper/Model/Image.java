package com.iskylar.yashika.quoteswallpaper.Model;

import java.io.Serializable;

/**
 * Created by Yashika on 05-07-2017.
 */

public class Image implements Serializable{
    int imageRes;
    String info;

    public Image(int imageRes, String info) {
        this.imageRes = imageRes;
        this.info = info;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
