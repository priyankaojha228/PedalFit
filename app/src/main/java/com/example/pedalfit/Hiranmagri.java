package com.example.pedalfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hiranmagri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiranmagri);
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println("Button Clicked");

                Intent i = new Intent(getApplicationContext(), activity_scan.class);
                startActivity(i);
            }
        });
    }
}