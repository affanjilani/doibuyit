package com.example.obiaf.doibuyit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {
    Button logIN;
    Button signUP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);

        logIN = (Button) findViewById(R.id.loginBtn);
        signUP = (Button) findViewById(R.id.signupBtn);

        logIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingActivity.this,login_activity.class);
                startActivity(i);
            }
        });

        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingActivity.this,signup.class);
                startActivity(i);
            }
        });
    }
}
