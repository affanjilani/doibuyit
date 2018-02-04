package com.example.obiaf.doibuyit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BudgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.budget_activity);

        final TextInputEditText budget = (TextInputEditText) findViewById(R.id.month_budget);
        ImageButton imageButton = (ImageButton) findViewById(R.id.next_btn1);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String budg = budget.getText().toString();
                Intent i = new Intent(BudgetActivity.this, MainActivity.class);
                i.putExtra("monthBudget",budg);
                startActivity(i);
            }
        });

    }
}
