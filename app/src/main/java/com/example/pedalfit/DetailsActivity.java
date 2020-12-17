package com.example.pedalfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView markertxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
       // markertxt = findViewById(R.id.marker);
       // String title = getIntent().getStringExtra("title");
      //  markertxt.setText(title);
        TextView t1 = findViewById(R.id.marker);
        TextView t2 = findViewById(R.id.marker1);
        TextView t3 = findViewById(R.id.marker2);
        TextView t4 = findViewById(R.id.marker3);
        TextView t5 = findViewById(R.id.marker4);
        TextView t6 = findViewById(R.id.marker5);
        TextView t7 = findViewById(R.id.marker6);

        String text1 = "Fatehsagar Cycle Stand";
        String text2 = "City Palace Cycle Stand";
        String text3 = "Badi Lake Cycle Stand";
        String text4 = "Hiran Magri Cycle Stand";
        String text5="Doodhtalai Cycle Stand";
        String text6 = "Rani Road Cycle Stand";
        String text7 = "Celebration Mall Cycle Stand";

        SpannableString s1 = new SpannableString(text1);
        SpannableString s2 = new SpannableString(text2);
        SpannableString s3 = new SpannableString(text3);
        SpannableString s4 = new SpannableString(text4);
        SpannableString s5 = new SpannableString(text5);
        SpannableString s6 = new SpannableString(text6);
        SpannableString s7 = new SpannableString(text7);

        ClickableSpan c1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i1 = new Intent(DetailsActivity.this,Fatehsagar.class);
                startActivity(i1);
            }
        };
        ClickableSpan c2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i2 = new Intent(DetailsActivity.this,CityPalace.class);
                startActivity(i2);
            }
        };
        ClickableSpan c3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i3 = new Intent(DetailsActivity.this,Badilake.class);
                startActivity(i3);
            }
        };
        ClickableSpan c4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i4 = new Intent(DetailsActivity.this,Hiranmagri.class);
                startActivity(i4);
            }
        };
        ClickableSpan c5 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i5 = new Intent(DetailsActivity.this,Doodhtalai.class);
                startActivity(i5);
            }
        };
        ClickableSpan c6 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i6 = new Intent(DetailsActivity.this,Raniroad.class);
                startActivity(i6);
            }
        };
        ClickableSpan c7 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i7 = new Intent(DetailsActivity.this,Celebration.class);
                startActivity(i7);
            }
        };

        s1.setSpan(c1,0,22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s2.setSpan(c2,0,23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s3.setSpan(c3,0,21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s4.setSpan(c4,0,23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s5.setSpan(c5,0,22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s6.setSpan(c6,0,21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s7.setSpan(c7,0,28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setText(s5);
        t6.setText(s6);
        t7.setText(s7);

        t1.setMovementMethod(LinkMovementMethod.getInstance());
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        t4.setMovementMethod(LinkMovementMethod.getInstance());
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        t6.setMovementMethod(LinkMovementMethod.getInstance());
        t7.setMovementMethod(LinkMovementMethod.getInstance());




    }
}