package com.example.sysfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sysfood.R;
import com.example.sysfood.model.CardFood;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    Context context;
    List<CardFood> cardFoodList;

    public CardAdapter(Context context, List<CardFood> cardFoodList) {
        this.context = context;
        this.cardFoodList = cardFoodList;
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_details_home, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {


        holder.foodImage.setImageResource(cardFoodList.get(position).getImageURL());
        holder.name.setText(cardFoodList.get(position).getName());
        holder.price.setText(cardFoodList.get(position).getPrice());
        holder.restaurantName.setText(cardFoodList.get(position).getRestaurantName());
        holder.rating.setText(cardFoodList.get(position).getRating());
        holder.save.setText(cardFoodList.get(position).getSave());
        holder.toppings.setText(cardFoodList.get(position).getToppings());
        holder.order.setText(cardFoodList.get(position).getOrder());

    }

    @Override
    public int getItemCount() {
        return cardFoodList.size();
    }

    public static final class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView price, name, restaurantName, rating, toppings, save, order;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.as_price);
            name = itemView.findViewById(R.id.sample_name);
            restaurantName = itemView.findViewById(R.id.restaurant_name);
            rating = itemView.findViewById(R.id.rating);
            toppings = itemView.findViewById(R.id.toppings);
            save = itemView.findViewById(R.id.save);
            order = itemView.findViewById(R.id.order);

        }
    }
}



