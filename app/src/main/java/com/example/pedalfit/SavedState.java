package com.example.pedalfit;

import android.content.Context;
import android.content.SharedPreferences;


public class SavedState {
    Context context;
    SharedPreferences sharedPreferences;

    public SavedState(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences("preferences",Context.MODE_PRIVATE);
    }
    public void setState(boolean bval){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("bkey",bval);
        editor.apply();
    }
    public boolean getState(){
        return sharedPreferences.getBoolean("bkey",false);
    }
}
