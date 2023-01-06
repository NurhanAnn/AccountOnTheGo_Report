package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pyears_spmrsm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyears_spmrsm);

        Button button1 = findViewById(R.id.BTN2020);
        Button button2 = findViewById(R.id.BTN2021);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pyears_spmrsm.this, TrialSPMRSM_2020.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pyears_spmrsm.this, TrialSPMRSM_2021.class);
                startActivity(intent);
            }
        });
    }
}