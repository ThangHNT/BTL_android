package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    Button btnMoveToLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnMoveToLogin = findViewById(R.id.btnMoveToLogin);
        btnMoveToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToLoginActivity();
            }
        });
    }

    private void MoveToLoginActivity() {
        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);
    }
}