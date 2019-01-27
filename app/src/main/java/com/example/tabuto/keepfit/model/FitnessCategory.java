package com.example.tabuto.keepfit.model;

import android.graphics.drawable.Drawable;

import com.example.tabuto.keepfit.R;

public class FitnessCategory {

    private String title;
    private String decription;
    private int image;

    public FitnessCategory(String title, String decription, int image) {
        this.title = title;
        this.decription = decription;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
