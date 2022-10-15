package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WorkoutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_page);
    }
    public void Back(View view) {
        startActivity(new Intent(getApplicationContext(), TrapsBack1.class)); //When the button pressed it will move to BMI Page
        finish();
    }
    public void Chest(View view) {
        startActivity(new Intent(getApplicationContext(), Chest1.class)); //When the button pressed it will move to BMI Page
        finish();
    }
    public void Biceps(View view) {
        startActivity(new Intent(getApplicationContext(), BicepsTriceps1.class)); //When the button pressed it will move to BMI Page
        finish();
    }
    public void Legs(View view) {
        startActivity(new Intent(getApplicationContext(), Leg1.class)); //When the button pressed it will move to BMI Page
        finish();
    }
    public void Home1(View view) {
        startActivity(new Intent(getApplicationContext(), Home.class)); //When the button pressed it will move to BMI Page
        finish();
    }

}