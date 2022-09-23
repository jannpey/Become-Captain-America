package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI1 extends AppCompatActivity {

    EditText weight, height;
    TextView result;
    String calculation, BMIressult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi1);


              height = findViewById(R.id.height);
              weight = findViewById(R.id.weight);
              result = findViewById(R.id.result);

            }


        public void calculateBMI(View view){

            String S2 = weight.getText().toString();
            String S1 = height.getText().toString();

            float weightV = Float.parseFloat(S1);
            float heightV = Float.parseFloat(S2)/100;

            float bmi = weightV / (heightV  * heightV); // Use to calculate the BMI

            calculation = "Result: \n\n" + bmi;

            result.setText(calculation);


        }

    public void home(View view) {
        startActivity(new Intent(getApplicationContext(), Home.class));
        finish();
    }


    }