package com.example.myapp.hero

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.R


class ProgrammingHeroActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programming_hero)


        val button: Button = findViewById(R.id.startGame)
        button.setOnClickListener {
            // Code here executes on main thread after user presses button
            val intent = Intent (applicationContext, MiniGameActivity::class.java)
            startActivity(intent)
        }
    }

}