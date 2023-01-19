package com.example.aotg_v1;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.aotg_v1.ui.home.HomeFragment;
import com.example.aotg_v1.ui.profile.ProfileFragment;
import com.example.aotg_v1.ui.quiz.QuizFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.example.aotg_v1.databinding.ActivityMainBinding;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    DBHelper DB;
    private ActivityMainBinding binding;
    private ProfileFragment profile_frag;
//    private static final long START_TIME_IN_MILLIS = 1500000;
//
//    private TextView mTextViewCountDown;
//    private Button mButtonStartPause;
//    private ImageButton mButtonReset;
//    private CountDownTimer mCountDownTimer;
//    private boolean mTimerRunning;
//    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
//
//    ViewPager viewPager;
//    //add images from drawable to array
//    int images[] = {R.drawable.imageviewer1, R.drawable.imageviewer2, R.drawable.imageviewer3, R.drawable.imageviewer4};
//    int currentPageCunter = 0;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.navView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.navigation_quiz:
                    replaceFragment(new QuizFragment());
                    break;
            }
            return true;
        });
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home,
//                R.id.navigation_quiz,
//                R.id.navigation_profile)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);

//        setContentView(R.layout.activity_main);
//
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home,
//                R.id.navigation_quiz,
//                R.id.navigation_profile
//
//        ).build();
//        NavigationUI.setupActionBarWithNavController(this, navController);
//        NavigationUI.setupWithNavController(binding.navView, navController);

        //pomodoro timer section
//        HomeFragment homeFragment = new HomeFragment();
//        mTextViewCountDown = findViewById(R.id.text_view_countdown);
//        mButtonStartPause = findViewById(R.id.button_start_pause);
//        mButtonReset = findViewById(R.id.button_reset);
//        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mTimerRunning) {
//                    pauseTimer();
//                } else {
//                    startTimer();
//                }
//            }
//        });
//
//        mButtonReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                resetTimer();
//            }
//        });
//
//        updateCountDownText();


//        //imageslider section
//        //find view by id
//        viewPager = findViewById(R.id.viewpager);
//        //add adapter
//        viewPager.setAdapter(new SliderAdapter(images, MainActivity.this));
//
//        //auto change image
//        final Handler handler = new Handler();
//        final Runnable update = new Runnable() {
//            @Override
//            public void run() {
//                if (currentPageCunter == images.length) {
//                    currentPageCunter = 0;
//
//                }
//
//                viewPager.setCurrentItem(currentPageCunter++, true);
//            }
//        };
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(update);
//            }
//        }, 3000, 3000);


//        EditText username_value = findViewById(R.id.input_username);
//        String username_string;
//
//        username_string = username_value.getText().toString();
//
//        System.out.println(username_string);
//        DB.displayAge(username_string);

//        DBHelper DB = new DBHelper(this);
//        //display age
////        Intent r = new Intent(MainActivity.this, RegisterActivity.class);
////        startActivity(r);
//        Intent intent = getIntent();
//        String user = intent.getStringExtra("username");
//        System.out.println(user);
//        ProfileFragment profFrag = new ProfileFragment(user);
//        TextView TVage = findViewById(R.id.TVage);
//        String age_value = DB.displayAge(user);
//        System.out.println(age_value + "----------------------");
//        profile_frag = new ProfileFragment(age_value);
////        TVage.setText("hello");
//        System.out.println("Sini masih di main activity nape null ek: " + age_value);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    //quiz section
    public void kahootsite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kahoot.it/"));
        startActivity(browserIntent);
    }

    public void wordwallsite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wordwall.net/ms-my/community/prinsip-perakaunan"));
        startActivity(browserIntent);
    }

    public void questionbanksite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://trial.spmpaper.me/?dir=Prinsip%20Perakaunan"));
        startActivity(browserIntent);
    }

    public void quizizzsite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quizizz.com/admin/quiz/57737dde4c3ef2675c244829/ulangkaji-prinsip-perakaunan"));
        startActivity(browserIntent);
    }


//    private void startTimer() {
//        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                mTimeLeftInMillis = millisUntilFinished;
//                updateCountDownText();
//            }
//
//            @Override
//            public void onFinish() {
//                mTimerRunning = false;
//                mButtonStartPause.setText("Start");
//                mButtonStartPause.setVisibility(View.INVISIBLE);
//                mButtonReset.setVisibility(View.VISIBLE);
//            }
//        }.start();
//
//        mTimerRunning = true;
//        mButtonStartPause.setText("pause");
//        mButtonReset.setVisibility(View.INVISIBLE);
//    }
//
//    private void pauseTimer() {
//        mCountDownTimer.cancel();
//        mTimerRunning = false;
//        mButtonStartPause.setText("Start");
//        mButtonReset.setVisibility(View.VISIBLE);
//    }
//
//    private void resetTimer() {
//        mTimeLeftInMillis = START_TIME_IN_MILLIS;
//        updateCountDownText();
//        mButtonReset.setVisibility(View.INVISIBLE);
//        mButtonStartPause.setVisibility(View.VISIBLE);
//    }
//
//    private void updateCountDownText() {
//        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
//        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
//
//        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
//
//        mTextViewCountDown.setText(timeLeftFormatted);
//    }
}