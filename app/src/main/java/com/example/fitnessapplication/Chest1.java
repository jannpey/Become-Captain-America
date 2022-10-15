package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Chest1 extends AppCompatActivity {

    private TextView countdownText;
    private Button  countdownButton;
    private Button countdownButtonReset;

    private CountDownTimer CountDownTimer;
    private  static final long START_TIME_IN_MILLIS = 1800000; //30 mins
    private boolean timerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest1);

        countdownText = findViewById(R.id.Chest1Text);
        countdownButton = findViewById(R.id.Chest1StartButton);
        countdownButtonReset = findViewById(R.id.chest1RestButton);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        countdownButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer(){
        CountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                countdownButton.setText("Start");
                countdownButton.setVisibility(View.INVISIBLE);
                countdownButtonReset.setVisibility(View.VISIBLE);

            }
        }.start();

        timerRunning = true;
        countdownButton.setText("Pause");
        countdownButtonReset.setVisibility(View.INVISIBLE);

    }

    private void pauseTimer(){
        CountDownTimer.cancel();
        timerRunning = false;
        countdownButton.setText("Start");
        countdownButtonReset.setVisibility(View.VISIBLE);

    }

    private void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        countdownButtonReset.setVisibility(View.VISIBLE);
        countdownButton.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        countdownText.setText(timeLeftFormatted);
    }

    public void NextExercise1(View view) {
        startActivity(new Intent(getApplicationContext(), Chest2.class));//When the button pressed it will move to Leg 2 Page
        finish();
    }




}