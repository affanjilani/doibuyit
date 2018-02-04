package com.example.obiaf.doibuyit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class signup extends AppCompatActivity {

    ArrayList<String> usernames = new ArrayList<>();
    ArrayList<String> passwords = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button overviewButton2 = (Button) findViewById(R.id.overviewButton2);                    //login button
        final EditText overviewUsernameInput = (EditText) findViewById(R.id.overviewUsernameInput2);   //Username
        final EditText overviewPasswordInput = (EditText) findViewById(R.id.overviewPasswordInput2);

        overviewButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = overviewUsernameInput.getText().toString();
                String p = overviewPasswordInput.getText().toString();

                usernames.add(u);
                passwords.add(p);
                Intent i = new Intent(signup.this,login_activity.class);
                i.putStringArrayListExtra("usernames",usernames);
                i.putStringArrayListExtra("passwords",passwords);
                startActivity(i);
            }
        });
    }

}
