package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class form4syllabus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form4syllabus);

        PDFView pdfView = findViewById(R.id.pdfview);
        pdfView.fromAsset("Concise Note Form 4.pdf").load();
    }

}