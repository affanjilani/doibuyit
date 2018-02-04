package com.example.obiaf.doibuyit;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_info_dialog);

        final TextInputEditText balance = (TextInputEditText) findViewById(R.id.balance);
        ImageButton imageButton = (ImageButton) findViewById(R.id.next_btn);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String bal = balance.getText().toString();
                Intent i = new Intent(MoneyActivity.this, BudgetActivity.class);
                i.putExtra("balance",bal);
                startActivity(i);
            }
        });


    }
}
