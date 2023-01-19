package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuizzizActivity extends AppCompatActivity {
    public DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizziz);

        Button sbmtmarks = findViewById(R.id.submitQ);
        sbmtmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tRightAnswerQ = findViewById(R.id.tRightAnswerQ);
                EditText tQuestionQ = findViewById(R.id.tQuestionQ);

                String marksQ_asString = tRightAnswerQ.getText().toString();
                int marksQ = Integer.parseInt(marksQ_asString);
                String totalQ_asString = tQuestionQ.getText().toString();
                int totalQ = Integer.parseInt(totalQ_asString);
                System.out.println(marksQ + "     " + totalQ);

                updatemarksandtotal(marksQ,totalQ);


            }
        });
    }

    public void updatemarksandtotal(int marksQ, int totalQ) {
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        TextView percentageQ = findViewById(R.id.percentageQ);
        System.out.println(user);
        double newTotalScore = marksQ + Double.parseDouble(DB.displayMarksQ(user));
        double newTotalQuestion = totalQ + Double.parseDouble(DB.displayTotalQ(user));

        DB.updateMarksQuizziz(user,(int) newTotalScore,(int) newTotalQuestion);

        double marks_percentage = (newTotalScore / newTotalQuestion) * 100;

        percentageQ.setText(marks_percentage+"");
    }
}