package com.mf.pradeg.DataModuls;

import android.content.Intent;

public class dataserves {
    int img;
    String title;

    public dataserves(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public dataserves() {
    }
}
