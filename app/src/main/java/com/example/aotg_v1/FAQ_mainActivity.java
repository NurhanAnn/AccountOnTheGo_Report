package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FAQ_mainActivity extends AppCompatActivity {

    TextView FAQanswer1;
    LinearLayout Question1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_main);

        FAQanswer1 = findViewById(R.id.FAQ_1_a);
        Question1 = findViewById(R.id.question1);

        Question1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);



    }

    public void expand(View view) {
        int v = (FAQanswer1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;


        TransitionManager.beginDelayedTransition(Question1, new AutoTransition());
        FAQanswer1.setVisibility(v);
    }
}