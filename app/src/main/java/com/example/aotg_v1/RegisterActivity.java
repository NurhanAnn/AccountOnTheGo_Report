package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private Button move_register2main;
    private TextView move_register2rlogin;
    private ImageView move_register2FAQ;
    private ImageView move_register2feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //register to main page (profile)
        move_register2main = findViewById(R.id.btn_register);
        move_register2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //register to login
        move_register2rlogin = findViewById(R.id.login);
        move_register2rlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //register to FAQ
        move_register2FAQ = findViewById(R.id.btnFAQ);
        move_register2FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, FAQ_mainActivity.class);
                startActivity(intent);
            }
        });

        //register to feedback
        move_register2feedback = findViewById(R.id.feedback_Icon);
        move_register2feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });
    }
}