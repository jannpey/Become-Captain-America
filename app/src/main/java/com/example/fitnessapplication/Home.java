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
        startActivity(new Intent(getApplicationContext(), BMI1.class)); //When the button pressed it will move to BMI Page
        finish();
    }

    public void profile(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));//When the button pressed it will move to Profile Page
        finish();
    }

    public void Workout(View view) {
        startActivity(new Intent(getApplicationContext(), WorkoutPage.class));//When the button pressed it will move to Workout Page
        finish();
    }

    public void Calories(View view) {
        startActivity(new Intent(getApplicationContext(), GetStart.class));//When the button pressed it will move to Workout Page
        finish();
    }

}