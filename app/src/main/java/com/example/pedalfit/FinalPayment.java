package com.example.pedalfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FinalPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);
        Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Payment Succesfull",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);

            }
        });
    }
}