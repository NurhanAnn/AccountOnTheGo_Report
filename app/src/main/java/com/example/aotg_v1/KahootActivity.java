package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KahootActivity extends AppCompatActivity {
    public DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kahoot);

        Button sbmtmarks = findViewById(R.id.submitK);
        sbmtmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tRightAnswerK = findViewById(R.id.tRightAnswerK);
                EditText tQuestionK = findViewById(R.id.tQuestionK);

                String marksK_asString = tRightAnswerK.getText().toString();
                int marksK = Integer.parseInt(marksK_asString);
                String totalK_asString = tQuestionK.getText().toString();
                int totalK = Integer.parseInt(totalK_asString);
                System.out.println(marksK + "     " + totalK);

                updatemarksandtotal(marksK,totalK);


            }
        });
    }

    public void updatemarksandtotal(int marksK, int totalK) {
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        TextView percentageK = findViewById(R.id.percentageK);

        double newTotalScore = marksK + Double.parseDouble(DB.displayMarksK(user));
        double newTotalQuestion = totalK + Double.parseDouble(DB.displayTotalK(user));

        DB.updateMarksKahoot(user,(int) newTotalScore,(int) newTotalQuestion);

        double marks_percentage = (newTotalScore / newTotalQuestion) * 100;

        percentageK.setText(marks_percentage+"");
    }
}