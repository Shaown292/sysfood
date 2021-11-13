package com.example.sysfood;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {
    Button btn_alreadyHaveAnAccount, btn_Go;
    EditText txt_fullName, txt_email, txt_password, txt_phone_no, txt_userName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        txt_fullName = findViewById(R.id.regName);
        txt_email = findViewById(R.id.regEmail);
        txt_password = findViewById(R.id.regPass);
        txt_phone_no = findViewById(R.id.regPhone);
        txt_userName = findViewById(R.id.regUserName);



        btn_alreadyHaveAnAccount = findViewById(R.id.btn_alreadyHaveAnAccount);
        btn_Go = findViewById(R.id.btnGo);


        btn_alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });

//        btn_Go.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Write a message to the database
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("message");
//
//                myRef.setValue("Hello, W!");
//
//            }
//        });

    }

    private boolean validName() {
        String val = txt_fullName.getText().toString();
        if (val.isEmpty()) {
            txt_fullName.setError("This Field can not be empty");
            return false;
        } else {
            txt_fullName.setError(null);
            return true;
        }
    }

    private boolean validUserName() {
        String val = txt_userName.getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (val.isEmpty()) {
            txt_userName.setError("This Field can not be empty");
            return false;
        } else if (val.length() >= 15) {
            txt_userName.setError("User name too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            txt_userName.setError("White space not allowed");
            return false;
        } else {
            txt_userName.setError(null);
            return true;
        }
    }

    private boolean validEmail() {
        String val = txt_email.getText().toString();
        String emailPatter = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            txt_email.setError("This Field can not be empty");
            return false;
        } else if (!val.matches(emailPatter)) {
            txt_email.setError("invalid Email");
            return false;
        } else {
            txt_email.setError(null);
            return true;
        }
    }

    private boolean validPassword() {
        String val = txt_password.getText().toString();

        String pass = "^" + "(?=.*\\d)" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[@#$%])" + ".{8,20}" + "$";

        if (val.isEmpty()) {
            txt_password.setError("This Field can not be empty");
            return false;
        } else if (!val.matches(pass)) {
            txt_password.setError("Password is too weak");
            Toast.makeText(SignUp.this, " Use 1 Upper case, 1 Special Character and 1 number", Toast.LENGTH_LONG).show();
            return false;
        } else {
            txt_password.setError(null);
            return true;
        }
    }

    private boolean validPhone() {
        String val = txt_fullName.getText().toString();
        if (val.isEmpty()) {
            txt_fullName.setError("This Field can not be empty");
            return false;
        } else {
            txt_fullName.setError(null);
            return true;
        }
    }

    public void registerUser (View view){

        if (!validName() | !validUserName() | !validEmail() | !validPassword() | !validPhone()) {
            return;
        }
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

//
        String  fullName = txt_fullName.getText().toString();
        String  userName = txt_userName.getText().toString();
        String email = txt_email.getText().toString();
        String phoneno = txt_phone_no.getText().toString();
        String password = txt_password.getText().toString();


        UserHelper userHelper = new UserHelper(fullName,email,password,phoneno, userName);
        reference.child(userName).setValue(userHelper);

        Toast.makeText(SignUp.this, "Your Account has been created", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SignUp.this, LogIn.class);
        startActivity(intent);


    }











}