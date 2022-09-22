package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void BMI(View view) {
        startActivity(new Intent(getApplicationContext(), BMI1.class));
        finish();
    }

    public void profile(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void workout(View view) {
        startActivity(new Intent(getApplicationContext(), workout.class));
        finish();
    }

}