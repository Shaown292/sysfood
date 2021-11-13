package com.example.sysfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sysfood.adapter.AsianFoodAdapter;
import com.example.sysfood.adapter.OrderAdapter;
import com.example.sysfood.databinding.ActivityAllOrdersBinding;
import com.example.sysfood.model.AsianFood;
import com.example.sysfood.model.OrderModel;
import com.example.sysfood.model.PopularFood;

import java.util.ArrayList;
import java.util.List;

public class All_Orders extends AppCompatActivity {

    ActivityAllOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAllOrdersBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


//        DBHelper dbHelper = new DBHelper(this);


        ArrayList<OrderModel> list = new ArrayList<>();

        list.add(new OrderModel(R.drawable.t_bone, "T-bone Steak", "100", "1"));
        list.add(new OrderModel(R.drawable.burger, "Burger", "230", "2"));
        list.add(new OrderModel(R.drawable.beefstreaks, "Beef Steak", "1250", "3"));
        list.add(new OrderModel(R.drawable.korean_set_menu, "Korean set menu", "300", "4"));




        setAllOrderRecyclerView(list);






    }


    private void setAllOrderRecyclerView(List<OrderModel> orderModelList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.allOrderRecyclerview.setLayoutManager(layoutManager);
        OrderAdapter orderAdapter = new OrderAdapter(this,orderModelList);
       binding.allOrderRecyclerview.setAdapter(orderAdapter);

    }




}