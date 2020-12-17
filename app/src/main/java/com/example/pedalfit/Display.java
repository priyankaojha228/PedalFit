package com.example.pedalfit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Display extends AppCompatActivity {
   private Switch switch1;
   SavedState savedState;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedState= new SavedState(this);
        if(savedState.getState()==true)
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        setContentView(R.layout.activity_display);
        switch1=findViewById(R.id.switch1);
        if(savedState.getState()==true)
            switch1.setChecked(true);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    savedState.setState(true);
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else {
                    savedState.setState(false);
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                }

        });


       // if(bundle!=null){
          //  if(bundle.getString("some")!=null){

          //  }
       // }
    }
}