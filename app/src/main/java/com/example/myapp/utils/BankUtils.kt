package com.example.myapp.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog


object BankUtils {


    const val SAVINGS = "Savings Account"
    const val CHECKING = "Checking Account"


   /*fun showMessage(context: Context?, msg: String?): AlertDialog {
        val builder: AlertDialog.Builder? = context?.let { AlertDialog.Builder(it) }
        builder?.setTitle(msg)
        builder?.setMessage(msg)
        builder?.setNegativeButton("OK", null)
        return builder!!.create()
    }*/

    fun showMessage(context: Context?, msg: String?) {
        if (context != null) {
            AlertDialog.Builder(context).apply {
                //setTitle("Withdraw Successful")
                setMessage(msg)
                setNegativeButton("OK", null)
                create().show()
            }
        }
    }


}