package com.example.daynightmode;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {
    ImageView sun,dayland,night;
    View daysky,nightsky;
    DayNightSwitch dayNightSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        sun=findViewById(R.id.sun);
        dayland=findViewById(R.id.day_Landscape);
        night=findViewById(R.id.night_Landscape);
        daysky=findViewById(R.id.day);
        nightsky=findViewById(R.id.night);
        dayNightSwitch=findViewById(R.id.dn_switch);

        sun.setTranslationY(-110);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night)
                {
                    sun.animate().translationY(110).setDuration(1000);
                    dayland.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);


                }
                else
                    {
                        sun.animate().translationY(-110).setDuration(1000);
                        dayland.animate().alpha(1).setDuration(1300);
                        daysky.animate().alpha(1).setDuration(1300);
                    }

            }
        });
    }
}