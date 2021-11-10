package com.example.sysfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sysfood.databinding.ActivityAsianFoodDetailsBinding;

public class AsianFoodDetails extends AppCompatActivity {
    ActivityAsianFoodDetailsBinding binding;

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAsianFoodDetailsBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(binding.getRoot());
        int image = getIntent().getIntExtra("imageURL", 0);
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String restaurantName = getIntent().getStringExtra("restaurantName");
        String rating = getIntent().getStringExtra("ratings");
        String toppings = getIntent().getStringExtra("toppings");

        binding.asianDetailsImage.setImageResource(image);
        binding.asianFoodName.setText(name);
        binding.asianFoodPrice.setText(String.format("%d", price));
        binding.restName.setText(restaurantName);
        binding.ratings.setText(rating);
        binding.topping.setText(toppings);


        DBHelper helper = new DBHelper(this);

        binding.asianPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted = helper.insertOrder(Integer.parseInt(binding.asianFoodPrice.getText().toString()),
                        binding.asianDetailsImage.getImageAlpha(),
                        binding.topping.getText().toString(),
                        binding.asianFoodName.getText().toString(),
                        Integer.parseInt(binding.asianQuantityNum.getText().toString())
                );
                if (isInserted){
                    Toast.makeText(AsianFoodDetails.this, "Your order has been placed", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AsianFoodDetails.this, HomePage.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(AsianFoodDetails.this, "Error", Toast.LENGTH_SHORT).show();


            }

        });


        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                displayQuantity();
                int foodPrice = price * quantity;
                String new_price = String.valueOf(foodPrice);
                binding.asianFoodPrice.setText(new_price);

            }
        });

        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (quantity == 0) {
                    Toast.makeText(AsianFoodDetails.this, "cant be less than 0", Toast.LENGTH_SHORT).show();
                } else
                    quantity--;
                displayQuantity();
                int food_Price = price * quantity;
                String new_price = String.valueOf(food_Price);
                binding.asianFoodPrice.setText(new_price);
            }
        });



    }

    private void displayQuantity() {
        binding.asianQuantityNum.setText(String.valueOf(quantity));
    }


}