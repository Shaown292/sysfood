package com.example.sysfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sysfood.databinding.ActivityOrderSampleBinding;

public class OrderSample extends AppCompatActivity {

    ActivityOrderSampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderSampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}