package com.example.myapp.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.model.BankAccount;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class BankingActivity extends AppCompatActivity {
    private TextInputEditText nameET;
    private TextInputEditText balanceET;
    private TextInputEditText accountNumberET;
    private int accountType = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);

        nameET = findViewById(R.id.nameET);
        balanceET = findViewById(R.id.balanceET);
        accountNumberET = findViewById(R.id.accountNumberET);
        RadioGroup typeGroup = findViewById(R.id.typeGroup);

        typeGroup.setOnCheckedChangeListener((radioGroup, i) -> accountType = radioGroup.indexOfChild(findViewById(i)));

    }

    public void openNewAccount(View view) {
        String name = Objects.requireNonNull(nameET.getText()).toString();
        String accountNumber = Objects.requireNonNull(accountNumberET.getText()).toString();
        double balance = Double.parseDouble(Objects.requireNonNull(balanceET.getText()).toString());

        BankAccount bankAccount = null;

        switch (accountType) {
            case 0:
                bankAccount = new SavingAccount(name, accountNumber, accountType, balance);
                break;
            case 1:
                bankAccount = new CheckingAccount(name, accountNumber, accountType, balance);
        }

        Intent intent = new Intent(BankingActivity.this, MainActivity.class);
        intent.putExtra("bank", bankAccount);
        startActivity(intent);

    }
}