package com.example.obiaf.doibuyit;

/**
 * Created by waelalhashemi on 2018-02-03.
 */

public class Customers {
    String name;
    String balance;
    String monthlyBudget;
    String moneySpentWeek;
    String moneySpentMonth;

    public Customers(String name, String balance, String monthlyBudget, String moneySpentWeek, String moneySpentMonth){
        this.name = name;
        this.balance = balance;
        this.monthlyBudget = monthlyBudget;
        this.moneySpentWeek = moneySpentWeek;
        this.moneySpentMonth = moneySpentMonth;
    }
}
