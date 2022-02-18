package com.example.myapp.bank;

import com.example.myapp.model.BankAccount;

public class SavingAccount extends BankAccount {
    public static  double interestRate = 6.0;
    public static  double lowerLimit = 1000.0;

    public SavingAccount(String accountName, String accountNumber, int accountType, double accountBalance) {
        super(accountName, accountNumber, accountType, accountBalance);
    }

    @Override
    public String withdraw(double amount) {
        if (super.getAccountBalance() - amount >= lowerLimit) {
            super.setAccountBalance(getAccountBalance() - amount);
            return "Withdrawn with amount "+amount;
        }

        return "You must withdraw <= 1000.0";
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        SavingAccount.interestRate = interestRate;
    }

    public static double getLowerLimit() {
        return lowerLimit;
    }

    public static void setLowerLimit(double lowerLimit) {
        SavingAccount.lowerLimit = lowerLimit;
    }
}
