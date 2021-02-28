package com.example.lab4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class My_adaptor extends RecyclerView.Adapter<My_adaptor.ViewHolder> {




List<Dishes> dishes;


        My_adaptor( List<Dishes> dishes) {

            this.dishes = dishes;

        }

        @NonNull
        @Override
        public My_adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

            View view = layoutInflater.inflate(R.layout.recycler_view_lab4, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.image.setImageResource(dishes.get(position).getImage());
            holder.name.setText(dishes.get(position).getName());



    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView name;
        RatingBar rating;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            image = itemView.findViewById(R.id.dish_image);

            name = itemView.findViewById(R.id.dish_name);

            rating = itemView.findViewById(R.id.ratingBar);

            image.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());


                builder.setTitle(" Alert ")
                        .setMessage(" Display info of selected dish ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(v.getRootView().getContext(), SecondAcitivty.class );

                                String d_Name = name.getText().toString();



                                image.setDrawingCacheEnabled(true);
                                Bitmap d_Image = image.getDrawingCache();





                                float d_Rate = rating.getRating();


                                intent.putExtra("DishName", d_Name);
                                intent.putExtra("Image", d_Image);
                                intent.putExtra("Rating", d_Rate);




                                v.getContext().startActivity(intent);
                            }
                        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getRootView().getContext(), "Canceled", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();

            }
        }
    }

