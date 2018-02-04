package com.example.obiaf.doibuyit;

/**
 * Created by waelalhashemi on 2018-02-03.
 */

public class Customers {
    String name;
    String balance;
    String monthlyBudget;
    String moneySpentWeekly;
    String moneySpentMonthly;


    public Customers(String name, String balance, String monthlyBudget, String moneySpentWeekly, String moneySpentMonthly)
        {
            this.name = name;
            this.balance = balance;
            this.monthlyBudget = monthlyBudget;
            this.moneySpentWeekly = moneySpentWeekly;
            this.moneySpentMonthly = moneySpentMonthly;
        }
    }

