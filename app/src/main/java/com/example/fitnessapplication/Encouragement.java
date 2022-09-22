package com.example.fitnessapplication;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class Encouragement  extends AppCompatActivity {
    android.widget.ImageButton ImageButton;

    @SuppressLint("WrongViewCast")
    @Override
     protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton = findViewById(R.id.but_enco);
        ImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void createNotification()
    {
        String ChannelID="01";
        if(Build.VERSION.SDK_INT>=Build. VERSION_CODES.BASE){
            CharSequence name =getString(com.google.firebase.messaging.R.string.common_google_play_services_notification_channel_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(ChannelID,name,importance);
            NotificationManager notificationManager =getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            NotificationCompat.Builder builder= new NotificationCompat.Builder(getApplicationContext(),ChannelID)
                    .setSmallIcon(R.drawable.iconotif)
                    .setContentTitle("Notification")
                    .setContentText("You can do it");
            notificationManager.notify(0,builder.build());

        }
    }
}

