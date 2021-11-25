package com.example.sysfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sysfood.adapter.AsianFoodAdapter;
import com.example.sysfood.adapter.PopularFoodAdapter;
import com.example.sysfood.model.AsianFood;
import com.example.sysfood.model.PopularFood;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {


    ImageView img_pro_pic;
    RecyclerView foodRecyclerView, asianFoodRecyclerView;
    PopularFoodAdapter popularFoodAdapter;
    AsianFoodAdapter asianFoodAdapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        img_pro_pic = findViewById(R.id.profile);
//        img_pro_pic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomePage.this, User_Profile.class);
//                startActivity(intent);
//            }
//        });
        floatingActionButton = findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, MapsActivity.class);
                startActivity(intent);
            }
        });





        List<PopularFood> popularFoodList = new ArrayList<>();
        popularFoodList.add(new PopularFood("Beef Steak", "1250", R.drawable.beefstreaks));
        popularFoodList.add(new PopularFood("Brunch", "180", R.drawable.breakfast));
        popularFoodList.add(new PopularFood("Burger", "120", R.drawable.burger));
        popularFoodList.add(new PopularFood("Chinese Brunch", "380", R.drawable.chinesebreakfast));
        popularFoodList.add(new PopularFood("Vegan's Choice", "120", R.drawable.veganschoice));


        setFoodRecyclerView(popularFoodList);

        List<AsianFood> asianFoodList = new ArrayList<>();


        asianFoodList.add(new AsianFood(R.drawable.t_bone, "T-Bone Steak", "1250", "Steak House Dhanmondi", "4.0", "Chicken Steak, Sauted vegetable, French Fry and Mashed Potato"));
        asianFoodList.add(new AsianFood(R.drawable.asiafood2, "Dessert", "300", "Pizza Burg", "4.0", "Extra cheese, Mushroom, beef, jalapeno"));
        asianFoodList.add(new AsianFood(R.drawable.chinesebreakfast, "Tender Beef Pizza", "300", "Pizza Burg", "4.0", "Extra cheese, Mushroom, beef, jalapeno"));
        asianFoodList.add(new AsianFood(R.drawable.french_fry, "French Fry", "80", "Chillox", "3.0", ""));
        asianFoodList.add(new AsianFood(R.drawable.fish_fry, "Fish Fry", "160", "Burger & Boost", "3.8", "Made with Mustard Oil "));
        asianFoodList.add(new AsianFood(R.drawable.chichen_steak_platter, "Chicken Steak Platter", "380", "Pinewood Cafe", "2.8", "Chicken Steak, Sauted vegetable, French Fry and Mashed Potato"));
        asianFoodList.add(new AsianFood(R.drawable.korean_set_menu, "Korean Set Menu", "400", "Yum Cha District", "3.2", "Fried Rice, wonton and Chilli Chicken  "));
        asianFoodList.add(new AsianFood(R.drawable.chickensteak, "Chicken Steak", "700", "Yum Cha District", "2.2", "Fried Rice, wonton and Chilli Chicken  "));
        asianFoodList.add(new AsianFood(R.drawable.koreanset, "Korean Set Menu", "460", "Yum Cha District", "3.2", "Fried Rice, wonton and Chilli Chicken  "));
        asianFoodList.add(new AsianFood(R.drawable.mixedsalad, "Mixed Salad", "260", "Yum Cha District", "4.1", "Fried Rice, wonton and Chilli Chicken  "));
        asianFoodList.add(new AsianFood(R.drawable.nachos, "Nachos Chips", "100", "Yum Cha District", "2.7", "Fried Rice, wonton and Chilli Chicken  "));
        asianFoodList.add(new AsianFood(R.drawable.wings, "Wings", "120", "Yum Cha District", "3.2", "Fried Rice, wonton and Chilli Chicken  "));




        setAsianFoodRecyclerView(asianFoodList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.order:
               Intent intent = new Intent(HomePage.this, All_Orders.class);
               startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFoodRecyclerView(List<PopularFood> popularFoodList) {
        foodRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
        foodRecyclerView.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this, popularFoodList);
        foodRecyclerView.setAdapter(popularFoodAdapter);

    }

    private void setAsianFoodRecyclerView(List<AsianFood> asianFoodList) {
        asianFoodRecyclerView = findViewById(R.id.AsianFood_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        asianFoodRecyclerView.setLayoutManager(layoutManager);
        asianFoodAdapter = new AsianFoodAdapter(this, asianFoodList);
        asianFoodRecyclerView.setAdapter(asianFoodAdapter);

    }


}