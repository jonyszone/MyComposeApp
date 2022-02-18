package com.example.myapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.model.BankAccount

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
        var bundle :Bundle ?=intent.extras
        val bankAccount: BankAccount = intent.getSerializableExtra("bank") as BankAccount
        if (bankAccount!=null){
            Toast.makeText(this, bankAccount.accountName, Toast.LENGTH_SHORT).show();
        }
    }
}