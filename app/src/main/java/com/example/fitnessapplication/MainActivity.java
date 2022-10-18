package com.example.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    TextView fullName,email, weight, expectWeight;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullName = findViewById(R.id.profileName);
        email = findViewById(R.id.profileEmail);
        weight = findViewById(R.id.profileWeight);
        expectWeight = findViewById(R.id.profileExpectWeight);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        button = findViewById(R.id.ShareButton);

        DocumentReference documentReference = fStore.collection("users").document(userId); // Fetch the User Data from FireStore
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                fullName.setText(documentSnapshot.getString("fName"));
                email.setText(documentSnapshot.getString("email"));
                weight.setText(documentSnapshot.getString("weight"));
                expectWeight.setText(documentSnapshot.getString("ExpectedWeight"));

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent =  new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Download this fantastic app and share with your friends. \n\n https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(sendIntent,"Choose one"));
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

    public void feedback(View view) {
        startActivity(new Intent(getApplicationContext(), Feedback.class));
        finish();
    }


}