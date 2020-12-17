package com.example.pedalfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;

public class Activity_signup extends AppCompatActivity {
    public Button signup, signin;
    public EditText mName, mEmail, mPassword1, mPassword2, mphone;
    public FirebaseAuth fAuth;
    public DatabaseReference reff;
    Users users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup = (Button) findViewById(R.id.button3);
        signin = (Button) findViewById(R.id.button6);

        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.editTextTextPersonName);
        mphone = findViewById(R.id.editTextPhone);
        mPassword1 = findViewById(R.id.editTextTextPersonName3);
        mPassword2 = findViewById(R.id.editTextTextPersonName4);
        users = new Users();
        reff = FirebaseDatabase.getInstance().getReference().child("Users");
        fAuth = FirebaseAuth.getInstance();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinact = new Intent(Activity_signup.this, LoginActivity.class);
                startActivity(signinact);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword1.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Field can't be empty");
                }else if (TextUtils.isEmpty(password)){
                    mPassword1.setError("Field can't be empty");
                    if (password.length() < 8) {
                        mPassword1.setError("Password must be of atleast 8 characters");
                    }
                }else {
                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Activity_signup.this, "User Registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent (Activity_signup.this, LoginActivity.class));
                            } else {
                                Toast.makeText(Activity_signup.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    String name= mName.getText().toString().trim();
                    String phone = mphone.getText().toString().trim();
                    users.setEmail(email);
                    users.setName(name);
                    users.setPhone(phone);
                    reff.push().setValue(users);
                }

            }
        });
    }
}