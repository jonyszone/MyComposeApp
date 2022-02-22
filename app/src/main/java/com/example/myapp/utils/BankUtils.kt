package com.example.myapp.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog

object BankUtils {


    const val SAVINGS = "Savings Account"
    const val CHECKINGS = "Checking Account"


    fun showMessage(context: Context?, msg: String?): AlertDialog {
        val builder: AlertDialog.Builder? = context?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Deposit Successful")
        builder?.setMessage(msg)
        builder?.setNegativeButton("OK", null)
        return builder!!.create()
    }

}