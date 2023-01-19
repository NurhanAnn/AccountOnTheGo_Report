package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class SPM_2020 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spm2020);


        PDFView pdfView = findViewById(R.id.pdfview);

        pdfView.fromAsset("SPM 2020.pdf").load();
    }
}