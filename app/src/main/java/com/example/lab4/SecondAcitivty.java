package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondAcitivty extends AppCompatActivity {


    String dishName = "";
    float dishRating = 0f;
    Bitmap d_dishImage;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivty);


        TextView dishNameTV = (TextView)findViewById(R.id.dish_name_second);
        TextView ratingTV = (TextView)findViewById(R.id.dish_rating_second);
        ImageView dishImage = (ImageView)findViewById(R.id.imageView_second);


        Intent intent = getIntent();

        dishName = intent.getStringExtra("DishName");
        dishRating = intent.getFloatExtra("Rating", 0f);
        d_dishImage = intent.getParcelableExtra("Image");




        dishNameTV.setText(dishName);
        ratingTV.setText("Rating " + dishRating);
        dishImage.setImageBitmap(d_dishImage);







    }
}