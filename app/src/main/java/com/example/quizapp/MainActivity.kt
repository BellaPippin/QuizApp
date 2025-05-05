package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var userName = findViewById<TextView>(R.id.userName)
        var btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            val userName = userName.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("USER_NAME", userName)
            startActivity(intent)
        }
        }


    }