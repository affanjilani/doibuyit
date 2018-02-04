package com.example.obiaf.doibuyit;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
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

public class MainActivity extends AppCompatActivity {


    DatabaseReference databaseCustomers;
    int counter = 0;
    ArrayList<String> userList = new ArrayList<>();
    ArrayList<String> passList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseCustomers = FirebaseDatabase.getInstance().getReference("Customers");
        Customers customer1 = new Customers("Affan", 12,"Affan69","sexy");
        databaseCustomers.child(counter + "").setValue(customer1);
        counter++;
        Customers customer2 = new Customers("Wael", 123,"wael12","sexy");
        databaseCustomers.child(counter + "").setValue(customer2);

    }


}
