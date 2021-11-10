package com.example.sysfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {

    Button btn_SignUp, btn_forgetPass, btn_logIn;
    EditText log_user_name, log_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        log_user_name = findViewById(R.id.logUser);
        log_password = findViewById(R.id.logPass);

        btn_SignUp = findViewById(R.id.btn_signUp);

        btn_forgetPass = findViewById(R.id.forgetPass);

        btn_logIn = findViewById(R.id.btnLogin);

        btn_forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });


    }

    private boolean validUserName() {
        String val = log_user_name.getText().toString();
        if (val.isEmpty()) {
            log_user_name.setError("This Field can not be empty");
            return false;
        } else {
            log_user_name.setError(null);
            return true;
        }
    }

    private boolean validPassword() {
        String val = log_password.getText().toString();

        if (val.isEmpty()) {
            log_password.setError("This Field can not be empty");
            return false;
        } else {
            log_password.setError(null);
            return true;
        }
    }

    public void logInUser(View view) {
        if (!validUserName() | !validPassword()) {
            return;
        } else {
            isUser();

        }

        String username = log_user_name.getText().toString();
        String Password = log_password.getText().toString();


    }

    private void isUser() {
        String userEnteredUserName = log_user_name.getText().toString().trim();
        String userEnteredPassword = log_password.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("userName").equalTo(userEnteredUserName);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    log_user_name.setError(null);

                    String passFromDB = snapshot.child(userEnteredUserName).child("password").getValue(String.class);

                    if (passFromDB.equals(userEnteredPassword)) {

                        log_user_name.setError(null);



                        String nameFromDB = snapshot.child(userEnteredUserName).child("fullName").getValue(String.class);
                        String userNameFromDB = snapshot.child(userEnteredUserName).child("userName").getValue(String.class);
                        String emailFromDB = snapshot.child(userEnteredUserName).child("email").getValue(String.class);
                        String phoneFromDB = snapshot.child(userEnteredUserName).child("phone_no").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(), HomePage.class);
                        intent.putExtra("fullName", nameFromDB);
                        intent.putExtra("userName", userNameFromDB);
                        intent.putExtra("password", passFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phone_no", phoneFromDB);
                        startActivity(intent);

                    } else {
                        log_password.setError("Wrong Password");
                        log_password.requestFocus();
                    }
                } else {
                    log_user_name.setError("Invalid User Name");
                    log_user_name.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}