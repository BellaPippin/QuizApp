package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val totalScore = intent.getIntExtra("TOTAL_SCORE", 0)
        val userName = intent.getStringExtra("USER_NAME")

        val txtResult = findViewById<TextView>(R.id.txtResult)
        val resultImage = findViewById<ImageView>(R.id.resultImage)
        val txtDesc = findViewById<TextView>(R.id.txtDesc)
        val restartButton = findViewById<Button>(R.id.restartButton)

        when {
            totalScore in 0..50 -> {
                txtResult.text = "$userName, you're a Tardigrade!"
                resultImage.setImageResource(R.drawable.tardigrade)
                txtDesc.text = "You’re indestructible, unbothered, and probably survived five apocalypses while napping in a damp towel."
            }
            totalScore in 51..100 -> {
                txtResult.text = "$userName, you're a Sunbathing Lizard."
                resultImage.setImageResource(R.drawable.lizard)
                txtDesc.text = "You do nothing all day, but with intention. You are the CEO of Vibing."
            }
            totalScore in 101..150 -> {
                txtResult.text = "$userName, you're an Owl."
                resultImage.setImageResource(R.drawable.owl)
                txtDesc.text = "You see everything. You judge silently. You hoot when things get messy."
            }
            totalScore in 151..200 -> {
                txtResult.text = "$userName, you're a screaming Goat."
                resultImage.setImageResource(R.drawable.goat)
                txtDesc.text = "You are loud, dramatic, and wildly relatable. People either love you or back away slowly."
            }
            totalScore > 200 -> {
                txtResult.text = "$userName, you're a Confused Octopus."
                resultImage.setImageResource(R.drawable.octopus)
                txtDesc.text = "You’re incredibly smart, but constantly questioning your life choices—especially why you put a sock on every arm."
            }
            else -> {
                txtResult.text = "$userName, you're a...Glitch in the Quiz Matrix."
                resultImage.setImageResource(R.drawable.unknown_creature)
                txtDesc.text = "Reality couldn't decide what you are, so it rendered a sus creature instead. Possibly part goat, part toaster. Who knows."
            }
        }

        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: closes the current activity so it's not on the back stack
        }





    }
}
