package com.example.pedalfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RideHistoryShow extends AppCompatActivity {
    public TextView a,b,c,d,e;
    public Button btn;
    public DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_history_show);
        b = findViewById(R.id.textView32);
        c = findViewById(R.id.textView33);
        d = findViewById(R.id.textView34);
        e = findViewById(R.id.textView35);
        btn = findViewById(R.id.button16);
        btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff= FirebaseDatabase.getInstance().getReference().child("pedalfit-84c86-default-rtdb").child("Users").child("-MOPpcxcHV2Kt_Q3EnNL");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String rides= dataSnapshot.child("rides").getValue(String.class).toString();
                        String Milestone= dataSnapshot.child("Milestone").getValue(String.class).toString();
                        String Distance= dataSnapshot.child("Distance").getValue(String.class).toString();
                        String hrs= dataSnapshot.child("hrs").getValue(String.class).toString();
                        Intent intent = new Intent(getApplicationContext(),Users.class);
                        intent.putExtra("rides", rides);
                        intent.putExtra("Milestone", Milestone);
                        intent.putExtra("Distance",Distance);
                        intent.putExtra("hrs", hrs);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }));

    }
}