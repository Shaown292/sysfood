package com.example.sysfood;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    Animation top_anim, bottom_anim;
    ImageView logo;
    TextView companyName, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        logo = findViewById(R.id.imgLogo);
        companyName = findViewById(R.id.txtComName);
        slogan = findViewById(R.id.txtSlogan);

        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);


        logo.setAnimation(top_anim);
        companyName.setAnimation(bottom_anim);
        slogan.setAnimation(bottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        },SPLASH_SCREEN);


    }
}