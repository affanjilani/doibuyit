package com.example.obiaf.doibuyit;

<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> Wael
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD

public class login_activity extends AppCompatActivity {

=======
import android.widget.TextView;

import java.util.ArrayList;

public class login_activity extends AppCompatActivity {

    Button overviewButton;
    EditText overviewUsernameInput;
    EditText overviewPasswordInput;
    TextView verify;
    ArrayList<String> users;
    ArrayList<String> passes;
>>>>>>> Wael
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
<<<<<<< HEAD
        final Button overviewButton = (Button) findViewById(R.id.overviewButton);                     //login button
        final EditText overviewUsernameInput = (EditText) findViewById(R.id.overviewUsernameInput);   //Username
        final EditText overviewPasswordInput = (EditText) findViewById(R.id.overviewPasswordInput);   //Password
=======
        overviewButton = (Button) findViewById(R.id.overviewButton);                     //login button
        overviewUsernameInput = (EditText) findViewById(R.id.overviewUsernameInput);   //Username
        overviewPasswordInput = (EditText) findViewById(R.id.overviewPasswordInput);   //Password
        verify = (TextView) findViewById(R.id.verify);
>>>>>>> Wael

        overviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                validateCustomer(overviewUsernameInput.getText().toString(),overviewPasswordInput.getText().toString());
=======
                validateLogin(overviewUsernameInput.getText().toString(),overviewPasswordInput.getText().toString());
>>>>>>> Wael
            }
        });
    }


<<<<<<< HEAD
    public void validateCustomer(String user, String pass){
        if(user.equals("Wael") && pass.equals("abc")) System.out.println("Yes");
        else System.out.println("No");
=======
    public void validateLogin(String user, String pass){
        users = getIntent().getStringArrayListExtra("usernames");
        passes = getIntent().getStringArrayListExtra("passwords");
        if(users.contains(user) && passes.contains(pass)){
            Intent i = new Intent(login_activity.this,MainActivity.class);
            startActivity(i);
        }
        else{
            verify.setText("Username or password is incorrect!");
        }

>>>>>>> Wael
    }
}
