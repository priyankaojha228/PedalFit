package com.example.pedalfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartRide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ride);
        Button button13 = findViewById(R.id.button10);
        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i2 = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i2);
            }
        });
        Button button12 = findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i2 = new Intent(getApplicationContext(), FinalPayment.class);
                startActivity(i2);
            }
        });

      /*  Button button15 = findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Support fragment = new Support();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();
            }
        }); */


        }
}