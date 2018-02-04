package com.example.obiaf.doibuyit;

import android.app.Dialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import org.w3c.dom.Text;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseCustomers;
    int counter = 0;
    ArrayList<Customers> customersList = new ArrayList<>();
    Context context = this;
    String balance;     //total amount of money customer has
    String monthlyBudget;   //how much money customer wants to spend during the month
    String moneySpentMonth; //how much money spent this month
    String moneySpentWeek; //how much money spent this week
    String name;    //name of customer
    TextView tv;
    String addedExpense;
    String addedExpenseWeek;
    String addedExpenseMonth;
    String amount;
    String moneyWeek;
    String moneyMonth;
    String balanceS;
    String moneyWeekS;
    String moneyMonthS;
    TextView deposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseCustomers = FirebaseDatabase.getInstance().getReference("Customers");
        balance = getIntent().getStringExtra("balance");
        monthlyBudget = getIntent().getStringExtra("monthlyBudget");
        databaseCustomers.child("0").child("balance").setValue(balance);
        databaseCustomers.child("0").child("monthlyBudget").setValue(monthlyBudget);
        databaseCustomers.child("0").child("moneySpentWeek").setValue("0");
        databaseCustomers.child("0").child("moneySpentMonth").setValue("0");
    }

    @Override
    protected void onStart() {
        super.onStart();

        tv = (TextView) findViewById(R.id.add_expense2);
        deposit = (TextView) findViewById(R.id.deposit);

        //all fields from activity_main.xml we will have to change
        final TextView overviewBalance = (TextView) findViewById(R.id.overviewBalance);   //total amount
        final TextView overviewMonthBudget = (TextView) findViewById(R.id.overviewMonthBudget);   //Monthly budget field
        final RoundCornerProgressBar progress1 = (RoundCornerProgressBar) findViewById(R.id.weeklyProgress);  //weekly progress bar
        final TextView amountLeftWk = (TextView) findViewById(R.id.amountLeftWk); //how much money left for week
        final TextView monthlyProgressText = (TextView) findViewById(R.id.monthlyProgressText);   //percent of monthly budget left
        final CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.monthlyProgress);  //monthly progress bar


        //all variables that will be used to show information
        databaseCustomers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    balance = String.valueOf(child.child("balance").getValue());
                    balanceS = balance;
                    monthlyBudget = String.valueOf(child.child("monthlyBudget").getValue());
                    moneySpentMonth = String.valueOf(child.child("moneySpentMonth").getValue());
                    moneyMonthS = moneySpentMonth;
                    moneySpentWeek = String.valueOf(child.child("moneySpentWeek").getValue());
                    moneyWeekS = moneySpentWeek;
                }

                //set total balance
                overviewBalance.setText(balance+"$");

                //set monthly budget
                overviewMonthBudget.setText("MONTHLY BUDGET: " + monthlyBudget);

                //set weekly progress
                progress1.setProgressColor(Color.parseColor("#FFFFFF"));
                progress1.setProgressBackgroundColor(ContextCompat.getColor(context, R.color.moneyGreen));
                progress1.setMax(Float.parseFloat(monthlyBudget) / 4);  //for a weekly budget we divide by 4
                progress1.setProgress(Float.parseFloat(moneySpentWeek));

                //set amount left text
                String rounded = roundNum(Double.parseDouble(monthlyBudget) / 4 - Double.parseDouble(moneySpentWeek));
                amountLeftWk.setText(rounded + "$ left for this week.");

                //set text for monthly progress percentage
                String prog = roundNum((Double.parseDouble(moneySpentMonth) / Double.parseDouble(monthlyBudget))*100);
                int prog2 = (int) Double.parseDouble(prog);
                monthlyProgressText.setText(prog2+"%");
                int animationDuration = 2500; // 2500ms = 2,5s
                circularProgressBar.setProgressWithAnimation((Float.parseFloat(monthlyBudget) / Float.parseFloat(moneySpentMonth)), animationDuration); // Default duration = 1500ms
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
        final Dialog dialog = new Dialog(this);
        final String expense;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_expense);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int screenWidth = (int) (metrics.widthPixels);
        int screenHeight = (int) (metrics.heightPixels);
        dialog.getWindow().setLayout(screenWidth,screenHeight);
        final ImageButton nextExpense = (ImageButton) dialog.findViewById(R.id.nextExpense);
        final TextInputEditText t = (TextInputEditText) dialog.findViewById(R.id.expense_budget);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                nextExpense.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        String te = t.getText().toString();
                        addedExpense = ""+(Double.parseDouble(balanceS) - Double.parseDouble(te) );
                        addedExpenseMonth = ""+(Double.parseDouble(moneyWeekS) + Double.parseDouble(te) );
                        addedExpenseWeek =  ""+(Double.parseDouble(moneyMonthS) + Double.parseDouble(te) );
                        databaseCustomers.child("0").child("balance").setValue(addedExpense);
                        databaseCustomers.child("0").child("moneySpentWeek").setValue(addedExpenseWeek);
                        databaseCustomers.child("0").child("moneySpentMonth").setValue(addedExpenseMonth);
                        //Intent i = new Intent(ExpenseActivity.this,MainActivity.class);
                        dialog.dismiss();
                    }
                });
            }
        });
        //Deposit
        final Dialog dialog2 = new Dialog(this);
        final String deposit2;
        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog2.setContentView(R.layout.deposit);

        dialog2.getWindow().setLayout(screenWidth,screenHeight);
        final ImageButton nextDeposit = (ImageButton) dialog2.findViewById(R.id.nextDeposit);
        final TextInputEditText d = (TextInputEditText) dialog2.findViewById(R.id.deposit_budget);
        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2.show();
                nextDeposit.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        String de = d.getText().toString();
                        addedExpense = ""+(Double.parseDouble(balanceS) + Double.parseDouble(de) );
                        databaseCustomers.child("0").child("balance").setValue(addedExpense);
                        //Intent i = new Intent(ExpenseActivity.this,MainActivity.class);
                        dialog2.dismiss();
                    }
                });
            }
        });
    }

    public static String roundNum(double dub){
        dub = dub*1000;
        int integ = (int) dub;
        integ = integ/10;
        dub = integ/100.0;
        return ""+dub;

    }
}
