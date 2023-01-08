package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button move_login2main;
    private TextView move_login2register;
    private ImageView move_login2FAQ;
    private ImageView move_login2feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //login to main page (profile)
        move_login2main = findViewById(R.id.btn_login);
        move_login2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //login to register
        move_login2register = findViewById(R.id.registerText);
        move_login2register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //login to FAQ
        move_login2FAQ = findViewById(R.id.btnFAQ);
        move_login2FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, FAQ_mainActivity.class);
                startActivity(intent);
            }
        });

        //login to feedback
        move_login2feedback = findViewById((R.id.feedback_Icon));
        move_login2feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });

    }
}