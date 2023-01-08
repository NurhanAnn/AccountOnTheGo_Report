package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FAQ_mainActivity extends AppCompatActivity {

    TextView FAQanswer1;
    LinearLayout Question1;
    TextView FAQanswer2;
    LinearLayout Question2;
    TextView FAQanswer3;
    LinearLayout Question3;
    TextView FAQanswer4;
    LinearLayout Question4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_main);
        //question1
        FAQanswer1 = findViewById(R.id.FAQ_1_a);
        Question1 = findViewById(R.id.question1);

        Question1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        //question2
        FAQanswer2 = findViewById(R.id.FAQ_2_a);
        Question2 = findViewById(R.id.question2);

        Question2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        //question3
        FAQanswer3 = findViewById(R.id.FAQ_3_a);
        Question3 = findViewById(R.id.question3);

        Question3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        //question4
        FAQanswer4 = findViewById(R.id.FAQ_4_a);
        Question4 = findViewById(R.id.question4);

        Question4.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        EditText ETFeedback = findViewById(R.id.ETFeedback3);
        Button BtnFeedback = findViewById(R.id.btnFeedback2);

        //the button OnClickListener to toast a message and share the cashback code is user has entered the feedback.
        BtnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String message = "Thank you for your question!";
                if (!ETFeedback.getText().toString().isEmpty())
                    message = message + "Should it be relevant we will add it to our FAQ list.";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

            }
        });
    }

    public void expand1(View view) {

        int v = (FAQanswer1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;


        TransitionManager.beginDelayedTransition(Question1, new AutoTransition());
        FAQanswer1.setVisibility(v);
    }

    public void expand2(View view) {
        int v = (FAQanswer2.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;


        TransitionManager.beginDelayedTransition(Question2, new AutoTransition());
        FAQanswer2.setVisibility(v);
    }

    public void expand3(View view) {
        int v = (FAQanswer3.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;


        TransitionManager.beginDelayedTransition(Question3, new AutoTransition());
        FAQanswer3.setVisibility(v);
    }

    public void expand4(View view) {
        int v = (FAQanswer4.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;


        TransitionManager.beginDelayedTransition(Question4, new AutoTransition());
        FAQanswer4.setVisibility(v);
    }
}