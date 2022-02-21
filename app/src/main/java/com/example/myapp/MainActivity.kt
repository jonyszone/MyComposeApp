package com.example.myapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.bank.CheckingAccount
import com.example.myapp.bank.SavingAccount
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.model.BankAccount
import com.example.myapp.utils.BankUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private val nameTV: TextView? = null
    //private val accountNumberTV: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        intent.extras
        val bankAccount: BankAccount = intent.getSerializableExtra("bank") as BankAccount
        //Toast.makeText(this, bankAccount.accountName, Toast.LENGTH_SHORT).show()

        showInfo(bankAccount)
    }

    private fun showInfo(bankAccount: BankAccount) {
        binding.rowAccountName.text = bankAccount.accountName
        binding.rowAccountNumber.text = bankAccount.accountNumber
        binding.rowAccountBalance.text = bankAccount.accountBalance.toString()

        when (bankAccount.accountType) {
            0 -> {
                binding.rateRow.visibility = View.VISIBLE
                binding.rowInterestRate.text = SavingAccount.interestRate.toString()
                binding.rowAccountType.text = BankUtils.SAVINGS
                binding.serviceRow.visibility = View.GONE
            }
            1 -> {
                binding.rowServiceCharge.text = CheckingAccount.serviceCharge.toString()
                binding.rowAccountType.text = BankUtils.CHECKINGS
            }
        }
    }
}