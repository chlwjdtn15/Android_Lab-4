package com.example.lab4;

import android.widget.RatingBar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class Dishes extends ViewModel {

   private String name = "";
   private int image = 0;



    Dishes(String name, int image) {

        this.name = name;
        this.image = image;


    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



}
