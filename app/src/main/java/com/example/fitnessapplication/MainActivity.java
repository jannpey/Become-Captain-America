package com.example.fitnessapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    TextView fullName,email,tvFeedback;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    RatingBar rbStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullName = findViewById(R.id.profileName);
        email = findViewById(R.id.profileEmail);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        tvFeedback = findViewById(R.id.tvFeedback);
        rbStars = findViewById(R.id.rbStars);

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                fullName.setText(documentSnapshot.getString("fName"));
                email.setText(documentSnapshot.getString("email"));
            }
        });


        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0)
                {
                    tvFeedback.setText("Very Dissatisfied");
                }
                else if(rating==1)
                {
                    tvFeedback.setText("Dissatisfied");
                }
                else if(rating==2 || rating==3)
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

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void Home(View view) {
        startActivity(new Intent(getApplicationContext(), Home.class));
        finish();
    }


}