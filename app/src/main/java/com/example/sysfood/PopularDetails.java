package com.example.sysfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sysfood.databinding.ActivityDetailsHomeBinding;


public class PopularDetails extends AppCompatActivity {

    ActivityDetailsHomeBinding binding;

    int quantity =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityDetailsHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



       int image = getIntent().getIntExtra("ImageURL", 0);

         int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");

        binding.asianDetailsImage.setImageResource(image);
        binding.asianFoodPrice.setText(String.format("%d",price));
        binding.asianFoodName.setText(name);

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
                    Toast.makeText(PopularDetails.this, "Your order has been placed", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(PopularDetails.this, HomePage.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(PopularDetails.this, "Error", Toast.LENGTH_SHORT).show();


            }

        });





        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity ++;
                displayQuantity ();
                int foodPrice = price* quantity;
                String new_price = String.valueOf(foodPrice);
                binding.asianFoodPrice.setText(new_price);

            }
        });
        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (quantity <= 1) {
                    Toast.makeText(PopularDetails.this, "Can't order less than 1", Toast.LENGTH_SHORT).show();
                }
                else
                    quantity --;
                displayQuantity ();
                int food_Price = price* quantity;
                String new_price = String.valueOf(food_Price);
                binding.asianFoodPrice.setText(new_price);
            }
        });




    }



    private void displayQuantity() {
       binding.asianQuantityNum.setText(String.valueOf(quantity));
    }

}