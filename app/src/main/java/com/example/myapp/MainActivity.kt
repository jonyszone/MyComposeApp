package com.example.myapp

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.bank.CheckingAccount
import com.example.myapp.bank.SavingAccount
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.model.BankAccount
import com.example.myapp.utils.BankUtils


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var bankAccount: BankAccount? = null
    //private val nameTV: TextView? = null
    //private val accountNumberTV: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        intent.extras
        bankAccount = intent.getSerializableExtra("bank") as BankAccount
        //Toast.makeText(this, bankAccount.accountName, Toast.LENGTH_SHORT).show()

        showInfo(bankAccount!!)
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
                binding.rowAccountType.text = BankUtils.CHECKING
            }
        }
    }


    fun depositAmount(view: View) {
        showDepositDialog()
    }

    private fun showDepositDialog() {
        // Set up the input
        val input = EditText(this)

        val builder: AlertDialog.Builder =
            AlertDialog.Builder(this)
        builder.setTitle("Deposit")

        // Specify the type of input expected;
        builder.setMessage("Enter Amount")
        input.inputType = InputType.TYPE_CLASS_NUMBER
        builder.setView(input)

        // Set up the buttons
        builder.setPositiveButton(
            "Deposit"
        ) { dialogInterface, i ->
            val amount: Double = input.text.toString().toDouble()

            val amt = bankAccount?.deposit(amount)

            binding.rowAccountBalance.text = bankAccount?.accountBalance.toString()

            val builder: AlertDialog.Builder =
                AlertDialog.Builder(this)
            builder.setTitle("Deposit Successful")
            builder.setMessage(amt)
            builder.setNegativeButton("OK", null)
            builder.create().show()

        }

        builder.setNegativeButton("Cancel", null)
        builder.create().show()

    }


    fun withdrawAmount(view: View) {
        showWithDrawDialog()

    }

    private fun showWithDrawDialog() {

        val input = EditText(this)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Withdraw")

        builder.setMessage("Enter Amount")
        input.inputType = InputType.TYPE_CLASS_NUMBER
        builder.setView(input)

        builder.setPositiveButton(
            "Withdraw"
        ) { dialogInterface, i ->
            val amount: Double = input.text.toString().toDouble()
            // withdrawFromAmount(amount)

            val amt = bankAccount?.withdraw(amount)
            binding.rowAccountBalance.text = bankAccount?.accountBalance.toString()

            val builder: AlertDialog.Builder =
                AlertDialog.Builder(this)
            builder.setTitle("Withdrawn Successfully")
            builder.setMessage(amt)
            builder.setNegativeButton("OK", null)
            builder.create().show()
        }

        builder.setNegativeButton("Cancel", null)
        builder.create().show()

    }

    /*
    private fun withdrawFromAmount(amount: Double) {
        val amt = bankAccount?.withdraw(amount)
        binding.rowAccountBalance.text = bankAccount?.accountBalance.toString()

        val builder: androidx.appcompat.app.AlertDialog.Builder =
            androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Deposit Successful")
        builder.setMessage(amt)
        builder.setNegativeButton("OK", null)
        builder.create().show()
    }*/

}

