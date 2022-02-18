package com.example.myapp.bank;

import com.example.myapp.model.BankAccount;

public class CheckingAccount extends BankAccount {
    public static double serviceCharge = 3_000.0;
    public static double upperLimit = 20_000.0;


    public CheckingAccount(String accountName, String accountNumber, int accountType, double accountBalance) {
        super(accountName, accountNumber, accountType, accountBalance);
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= upperLimit){
            super.setAccountBalance(super.getAccountBalance() - amount);
            return "Withdrawn amount "+amount;
        }
        return "You must withdraw less than or equal to 20000.0";
    }

    public static double getServiceCharge() {
        return serviceCharge;
    }

    public static void setServiceCharge(double serviceCharge) {
        CheckingAccount.serviceCharge = serviceCharge;
    }

    public static double getUpperLimit() {
        return upperLimit;
    }

    public static void setUpperLimit(double upperLimit) {
        CheckingAccount.upperLimit = upperLimit;
    }
}
