package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WordwallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordwall);
    }

    /*public void BtnSubmitOn

        EditText tRightAnswerWW = findViewById(R.id.tRightAnswersWW);
        EditText tQuestionWW = findViewById(R.id.tQuestionWW);
        TextView percentageWW = findViewById(R.id.percentageWW);

        double newTotalScore = tRightAnswersWW + retrievefromdatabase;
        double newTotalQuestion = tQuestionWW + retrievefromdatabase;

        double overallMarks = newTotalScore / newTotalQuestion;

        percentageWW.setText(Double.toString(overallMarks));

    }*/
}
