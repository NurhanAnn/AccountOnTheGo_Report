package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class form5syllabus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form5syllabus);

        PDFView pdfView = findViewById(R.id.pdfview);
        pdfView.fromAsset("Concise Notes Form 5.pdf").load();
    }
}