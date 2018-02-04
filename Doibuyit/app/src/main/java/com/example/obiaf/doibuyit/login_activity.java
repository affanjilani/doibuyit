package com.example.obiaf.doibuyit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final Button overviewButton = (Button) findViewById(R.id.overviewButton);                     //login button
        final EditText overviewUsernameInput = (EditText) findViewById(R.id.overviewUsernameInput);   //Username
        final EditText overviewPasswordInput = (EditText) findViewById(R.id.overviewPasswordInput);   //Password

        overviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateCustomer(overviewUsernameInput.getText().toString(),overviewPasswordInput.getText().toString());
            }
        });
    }


    public void validateCustomer(String user, String pass){
        if(user.equals("Wael") && pass.equals("abc")) System.out.println("Yes");
        else System.out.println("No");
    }
}
