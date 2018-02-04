package com.example.obiaf.doibuyit;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoundCornerProgressBar progress1 = (RoundCornerProgressBar) findViewById(R.id.weeklyProgress);
        progress1.setProgressColor(Color.parseColor("#FFFFFF"));
        progress1.setProgressBackgroundColor(ContextCompat.getColor(this.context, R.color.moneyGreen));
        progress1.setMax(250);
        progress1.setProgress(150);

        CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.monthlyProgress);
        int animationDuration = 2500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(65, animationDuration); // Default duration = 1500ms

    }

}
