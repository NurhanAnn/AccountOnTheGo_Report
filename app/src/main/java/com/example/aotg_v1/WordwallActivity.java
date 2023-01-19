package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WordwallActivity extends AppCompatActivity {
    public DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordwall);

        Button sbmtmarks = findViewById(R.id.submitWW);
        sbmtmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tRightAnswerWW = findViewById(R.id.tRightAnswerWW);
                EditText tQuestionWW = findViewById(R.id.tQuestionWW);

                String marksWW_asString = tRightAnswerWW.getText().toString();
                int marksWW = Integer.parseInt(marksWW_asString);
                String totalWW_asString = tQuestionWW.getText().toString();
                int totalWW = Integer.parseInt(totalWW_asString);
                System.out.println(marksWW + "     " + totalWW);

                updatemarksandtotal(marksWW,totalWW);


            }
        });
    }

    public void updatemarksandtotal(int marksWW, int totalWW) {
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        TextView percentageWW = findViewById(R.id.percentageWW);

        double newTotalScore = marksWW + Double.parseDouble(DB.displayMarksWW(user));
        double newTotalQuestion = totalWW + Double.parseDouble(DB.displayTotalWW(user));

        DB.updateMarksWordwall(user,(int) newTotalScore,(int)newTotalQuestion);

        double marks_percentage = (newTotalScore / newTotalQuestion) * 100;

        percentageWW.setText(marks_percentage+"");
    }
}
