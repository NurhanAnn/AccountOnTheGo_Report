package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class SPM_2021 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spm2021);


        PDFView pdfView = findViewById(R.id.pdfview);

        pdfView.fromAsset("spm2021.pdf").load();
    }
}