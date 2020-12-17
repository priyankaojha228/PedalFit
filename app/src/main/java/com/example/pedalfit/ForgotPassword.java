package com.example.pedalfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText fem;
    private Button respass;
    FirebaseAuth faut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        fem = (EditText) findViewById(R.id.editTextTextPersonName);
        faut = FirebaseAuth.getInstance();
        respass = findViewById(R.id.button14);
        respass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = fem.getText().toString().trim();
                if(email.isEmpty()){
                    fem.setError("Email is required");
                }
                faut.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Email has been sent",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                        }
                    }
                });

            }
        });

    }
}