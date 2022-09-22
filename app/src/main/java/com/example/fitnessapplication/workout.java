package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class workout extends AppCompatActivity {
    TextView titlepage, subtitle, title2, subtitle2;
    View line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout1);

        titlepage=(TextView) findViewById(R.id.titlepage);
        subtitle=(TextView) findViewById(R.id.subtitle);
        title2=(TextView) findViewById(R.id.title2);
        subtitle2=(TextView) findViewById(R.id.subtitle2);

        line = (View) findViewById(R.id.line);




    }

    public void Home1(View view) {
        startActivity(new Intent(getApplicationContext(), Home.class));
        finish();
    }


}