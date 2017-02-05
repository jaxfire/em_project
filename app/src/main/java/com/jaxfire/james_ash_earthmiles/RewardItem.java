package com.jaxfire.james_ash_earthmiles;

import android.graphics.Bitmap;

public class RewardItem {

    //TODO These are example
    private String companyName;
    private String description;
    //private Bitmap image;

    public RewardItem(String companyName, String description){
        this.companyName = companyName;
        this.description = description;
        //this.image = image;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

}