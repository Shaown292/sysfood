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

import com.example.sysfood.AsianFoodDetails;
import com.example.sysfood.R;
import com.example.sysfood.model.AsianFood;

import java.util.List;

public class AsianFoodAdapter extends RecyclerView.Adapter<AsianFoodAdapter.AsianFoodViewHolder> {

    Context context;
    List<AsianFood>asianFoodList;

    public AsianFoodAdapter(Context context, List<AsianFood>asianFoodList) {
        this.context = context;
        this.asianFoodList = asianFoodList;

    }


    @NonNull
    @Override
    public AsianFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.asian_food_row, parent, false);
        return new AsianFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsianFoodViewHolder holder, int position) {

        final AsianFood model = asianFoodList.get(position);
        holder.foodImage.setImageResource(model.getImageURL());
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.restaurantName.setText(model.getRestaurantName());
        holder.rating.setText(model.getRating());
        holder.toppings.setText(model.getToppings());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AsianFoodDetails.class);
                intent.putExtra("imageURL",model.getImageURL());
                intent.putExtra("name", model.getName());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("restaurantName", model.getRestaurantName());
                intent.putExtra("ratings", model.getRating());
                intent.putExtra("toppings", model.getToppings());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return asianFoodList.size();
    }

    public static final class AsianFoodViewHolder extends  RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView price, name, restaurantName, rating, toppings;

        public AsianFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.as_price);
            name = itemView.findViewById(R.id.sample_name);
            restaurantName = itemView.findViewById(R.id.restaurant_name);
            rating = itemView.findViewById(R.id.rating);
            toppings = itemView.findViewById(R.id.toppings);




        }
    }
}
