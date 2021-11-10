package com.example.sysfood.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sysfood.PopularDetails;
import com.example.sysfood.R;
import com.example.sysfood.model.PopularFood;

import java.util.List;

public class PopularFoodAdapter extends RecyclerView.Adapter<PopularFoodAdapter.PopularFoodViewHolder> {
    static Context context;
    List<PopularFood> popularFoodList;


    public PopularFoodAdapter(Context context, List<PopularFood> popularFoodList) {
        this.context = context;
        this.popularFoodList = popularFoodList;
    }

    @NonNull
    @Override
    public PopularFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_food_row_item, parent, false);
        return new PopularFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularFoodViewHolder holder, int position) {

        final  PopularFood model = popularFoodList.get(position);

        holder.foodImage.setImageResource(model.getImageURL());
        holder.Name.setText(model.getName());
        holder.Price.setText(model.getPrice());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PopularDetails.class);
                intent.putExtra("ImageURL", model.getImageURL());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("name", model.getName());
               context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return popularFoodList.size();
    }


    public static final class PopularFoodViewHolder extends RecyclerView.ViewHolder {


        ImageView foodImage;
        TextView Price, Name;

        public PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.image);
            Price = itemView.findViewById(R.id.as_price);
            Name = itemView.findViewById(R.id.sample_name);



        }



        }

    }
