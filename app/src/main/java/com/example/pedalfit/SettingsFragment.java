package com.example.pedalfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        Button button4 = (Button) view.findViewById(R.id.button4);
        Button logout = (Button) view.findViewById(R.id.button17);
        //Button button5 = (Button) view.findViewById(R.id.button5);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),Display.class);
                startActivity(in);

            }
        });
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Logout.class);
                startActivity(intent);

            }
        });
        /*button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PrivacyPolicy.class);
                startActivity(intent);
            }
        }); */

        return view;
    }

}

