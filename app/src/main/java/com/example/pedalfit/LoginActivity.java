package com.example.pedalfit;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button signup;
    Button login;
    EditText mEmail, mPassword1;
    public FirebaseAuth fAuth;
    TextView text;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail = findViewById(R.id.editTextTextPersonName);
        mPassword1 = findViewById(R.id.editTextTextPassword);
        text= findViewById(R.id.text);
        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        signup = (Button) findViewById(R.id.button1);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Activity_signup.class));
            }
        });
        login = (Button) findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword1.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Field can't be empty");

                } else if(TextUtils.isEmpty(password)){
                    mPassword1.setError("Field can't be empty");
                }
                else
                {
                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this ,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                LoginActivity.this.finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotPasswordActivity = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(forgotPasswordActivity);
                LoginActivity.this.finish();
            }
        });
    }
}