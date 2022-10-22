package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    TextView tvFeedback;
    RatingBar rbStars;

    protected boolean isFeedbackEmpty(String feedback) {
        if(feedback.equals("")){

            return true;
        }
        return false;
    }

    protected boolean isNameEmpty(String name) {
        if(name.equals("")){

            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        tvFeedback = findViewById(R.id.tvFeedback);
        rbStars = findViewById(R.id.rbStars);

        final EditText name = findViewById(R.id.username);
        final EditText feedback = findViewById(R.id.feedback);
        Button btn = findViewById(R.id.btn_send);
        FBaccess access = new FBaccess();

        btn.setOnClickListener(v->{
            FBmessage message = new FBmessage(name.getText().toString(),feedback.getText().toString());
            if(name.equals("")){
                name.setError("Name is Required.");
                return;
            }

            if(feedback.equals("")){
                feedback.setError("Feedback is Required.");
                return;
            }

            access.add(message).addOnSuccessListener(suc ->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, "Error!" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });



        });
        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0 || rating==0.5)
                {
                    tvFeedback.setText("Very Dissatisfied");
                }
                else if(rating==1 || rating==1.5)
                {
                    tvFeedback.setText("Dissatisfied");
                }
                else if(rating==2 || rating==2.5 || rating==3 || rating==3.5)
                {
                    tvFeedback.setText("OK");
                }
                else if(rating==4)
                {
                    tvFeedback.setText("Satisfied");
                }
                else
                {
                    tvFeedback.setText("Very Satisfied");
                }
            }
        });
    }

    public void HOME(View view) {
        startActivity(new Intent(getApplicationContext(), Home.class));
        finish();
    }
}