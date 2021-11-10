package com.example.sysfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class User_Profile extends AppCompatActivity {

    EditText full_name, email_address, mobile, Password;
    TextView full_name_label, user_name_label;
    Button btn_home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        full_name = findViewById(R.id.fullname_profile);

        email_address = findViewById(R.id.email_profile);
        mobile = findViewById(R.id.phone_no_profile);
        Password = findViewById(R.id.password_profile);
        full_name_label = findViewById(R.id.fullname_label);
        user_name_label = findViewById(R.id.username_label);
        btn_home = findViewById(R.id.btn_update_profile);

        ShowAllData ();
    }

    private void ShowAllData() {
        Intent intent = getIntent();
        String users_username = intent.getStringExtra("userName");
        String users_name = intent.getStringExtra("fullName");
        String users_email = intent.getStringExtra("email");
        String users_phone_no = intent.getStringExtra("phone_no");
        String users_password = intent.getStringExtra("password");

        full_name_label.setText(users_name);
        user_name_label.setText(users_username);
        full_name.setText(users_name);
        email_address.setText(users_email);
        mobile.setText(users_phone_no);
        Password.setText(users_password);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Profile.this, HomePage.class);
                startActivity(intent);
            }
        });


    }
}