package com.example.pedalfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Logout extends AppCompatActivity {
    public FirebaseAuth fauth;
    public Button yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        fauth = FirebaseAuth.getInstance();
        yes= (Button)findViewById(R.id.button18);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fauth.signOut();
                finish();
                startActivity(new Intent(Logout.this,LoginActivity.class));
            }
        });
    }
}