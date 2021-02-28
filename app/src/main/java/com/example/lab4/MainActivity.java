package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycle);


        List<Dishes> dishes = getData();
        My_adaptor adaptor = new My_adaptor(dishes);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        recyclerView.setAdapter(adaptor);





    }




    public List<Dishes> getData() {



        List<Dishes> dishes = new ArrayList<>();




        Dishes d1 = new Dishes("Fish", R.mipmap.fish);
        dishes.add(d1);
        Dishes d2 = new Dishes("Chicken", R.mipmap.chicken);
        dishes.add(d2);
        Dishes d3 = new Dishes("Pizza", R.mipmap.pizza);
        dishes.add(d3);



        return dishes;

    }



}