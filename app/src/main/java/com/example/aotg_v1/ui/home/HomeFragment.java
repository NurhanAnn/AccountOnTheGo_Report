package com.example.aotg_v1.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.example.aotg_v1.MainActivity;
import com.example.aotg_v1.Notes;
import com.example.aotg_v1.Pyears;
import com.example.aotg_v1.R;
import com.example.aotg_v1.SettingsActivity;
import com.example.aotg_v1.SliderAdapter;
import com.example.aotg_v1.databinding.FragmentHomeBinding;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
//import java.util.Locale;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;



    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //auto change image
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length) {
                    currentPageCunter = 0;

                }

                viewPager.setCurrentItem(currentPageCunter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);
    }*/

    //timer duration
    private static final long START_TIME_IN_MILLIS = 1500000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private ImageButton mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    ViewPager viewPager;
    //add images from drawable to array
    int images[] = {R.drawable.imageviewer1, R.drawable.imageviewer2, R.drawable.imageviewer3, R.drawable.imageviewer4};
    int currentPageCunter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();


        View view = inflater.inflate(R.layout.fragment_home,container,false);

        mTextViewCountDown = view.findViewById(R.id.text_view_countdown);
        mButtonStartPause = view.findViewById(R.id.button_start_pause);
        mButtonReset = view.findViewById(R.id.button_reset);
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        ImageButton mButtonReset = view.findViewById(R.id.button_reset);
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        //imageslider section
        //find view by id

        viewPager = view.findViewById(R.id.viewpager);
        //add adapter
        viewPager.setAdapter(new SliderAdapter(images, getContext()));

        //auto change image
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length) {
                    currentPageCunter = 0;

                }

                viewPager.setCurrentItem(currentPageCunter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);


        return view;
    }
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
                showAlertDialogTimeUp();
            }

        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }
    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        //Navigate from homeFragment to Pyear1activity via button
        Button BtnPyears = view.findViewById(R.id.BtnPyears);
        BtnPyears.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Pyears.class);
            startActivity(intent);
        });

        //Navigate from homeFragment to Notes1activity via button
        Button BtnNotes = view.findViewById(R.id.BtnNotes);
        View.OnClickListener OCLNotes = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), Notes.class);
                startActivity(intent);
//                Navigation.findNavController(view).navigate(R.id.navigation_notes);
            }
        };
        BtnNotes.setOnClickListener(OCLNotes);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showAlertDialogTimeUp(){
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setTitle("Pomodoro Timer");
        alert.setMessage("Your time is up!");

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alert.create().show();
    }
}