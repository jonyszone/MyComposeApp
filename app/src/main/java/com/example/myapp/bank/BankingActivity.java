package com.example.myapp.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.model.BankAccount;
import com.google.android.material.textfield.TextInputEditText;

public class BankingActivity extends AppCompatActivity {
    private TextInputEditText nameET, balanceET;
    private int accountType = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);

        nameET = findViewById(R.id.nameET);
        balanceET = findViewById(R.id.balanceET);
        RadioGroup typeGroup = findViewById(R.id.typeGroup);

        typeGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            accountType = radioGroup.indexOfChild(findViewById(i));
        });

    }

    public void openNewAccount(View view) {
        String name = nameET.getText().toString();
        double balance = Double.parseDouble(balanceET.getText().toString());

        BankAccount bankAccount = null;

        switch (accountType) {
            case 0: bankAccount = new SavingAccount(name, "SA001", accountType, balance);
            break;
            case 1: bankAccount = new CheckingAccount(name, "CA001", accountType, balance);
        }

        Intent intent = new Intent(BankingActivity.this, MainActivity.class);
        intent.putExtra("bank", bankAccount);
        startActivity(intent);

    }
}