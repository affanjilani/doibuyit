package com.example.obiaf.doibuyit;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

    public class login_activity extends AppCompatActivity {

        Button overviewButton;
        EditText overviewUsernameInput2;
        EditText overviewPasswordInput2;
        TextView verify;
        ArrayList<String> users;
        ArrayList<String> passes;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
            Button overviewButton = (Button) findViewById(R.id.overviewButton);                     //login button
            final EditText overviewUsernameInput2 = (EditText) findViewById(R.id.overviewUsernameInput2);   //Username
            final EditText overviewPasswordInput2 = (EditText) findViewById(R.id.overviewPasswordInput2);   //Password
            overviewButton = (Button) findViewById(R.id.overviewButton);                     //login button

            verify = (TextView) findViewById(R.id.verify);

            overviewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validateLogin(overviewUsernameInput2.getText().toString(), overviewPasswordInput2.getText().toString());
                }
            });
        }

        public void validateLogin(String user, String pass) {
            users = getIntent().getStringArrayListExtra("usernames");
            passes = getIntent().getStringArrayListExtra("passwords");
            if (users.contains(user) && passes.contains(pass)) {
                Intent i = new Intent(login_activity.this, MoneyActivity.class);
                startActivity(i);
            } else {
                verify.setText("Username or password is incorrect!");
            }

        }
    }

