package com.example.myapp.model;

import java.io.Serializable;

public abstract class BankAccount implements Serializable {
    private String accountName;
    private String accountNumber;
    private int accountType;
    private double accountBalance;

    public BankAccount(String accountName, String accountNumber, int accountType, double accountBalance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public abstract String withdraw(double amount);

    public final String deposit(double amount) {
        setAccountBalance(getAccountBalance() + amount);

        return "Credited Amount "+amount;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
