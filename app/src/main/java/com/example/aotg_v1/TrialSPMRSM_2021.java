package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class TrialSPMRSM_2021 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_spmrsm2021);


        PDFView pdfViews = findViewById(R.id.pdfview);

        pdfViews.fromAsset("TRIAL SPMRSM 2021.pdf").load();
    }
}