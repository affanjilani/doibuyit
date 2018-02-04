package com.example.obiaf.doibuyit;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class ExpenseActivity extends MainActivity {

    ImageButton next;
    TextInputEditText amo;
    String addedExpense;
    String addedExpenseWeek;
    String addedExpenseMonth;
    String amount;
    String moneyWeek;
    String moneyMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        next = (ImageButton) findViewById(R.id.nextExpense);
        amo = (TextInputEditText) findViewById(R.id.expense_budget);

        databaseCustomers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    amount = String.valueOf(child.child("balance").getValue());
                    moneyWeek = String.valueOf(child.child("moneySpentWeek").getValue());
                    moneyMonth = String.valueOf(child.child("moneySpentMonth").getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedExpense = ""+(Double.parseDouble(amount) - Double.parseDouble(amo.getText().toString()) );
                addedExpenseMonth = ""+(Double.parseDouble(moneyWeek) + Double.parseDouble(amo.getText().toString()) );
                addedExpenseWeek =  ""+(Double.parseDouble(moneyMonth) + Double.parseDouble(amo.getText().toString()) );
                databaseCustomers.child("0").child("balance").setValue(addedExpense);
                databaseCustomers.child("0").child("moneySpentWeek").setValue(addedExpenseWeek);
                databaseCustomers.child("0").child("moneySpentMonth").setValue(addedExpenseMonth);
                Intent i = new Intent(ExpenseActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
