package com.example.fitnessapplication;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBaccess {
    private DatabaseReference databaseReference;

    public FBaccess(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(FBmessage.class.getSimpleName());
    }
    public Task<Void> add(FBmessage message){
        return databaseReference.push().setValue(message);

    }

}
