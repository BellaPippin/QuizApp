package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val userName = intent.getStringExtra("USER_NAME")

        val txtWelcome = findViewById<TextView>(R.id.txtWelcome)
        txtWelcome.text = "Welcome, $userName!"


        var rb1 = findViewById<RadioButton>(R.id.rb1)
        var rb2 = findViewById<RadioButton>(R.id.rb2)
        var rb3 = findViewById<RadioButton>(R.id.rb3)
        var rb4 = findViewById<RadioButton>(R.id.rb4)

        var seek1 = findViewById<SeekBar>(R.id.seek1)

        var switch1 = findViewById<Switch>(R.id.switch1)

        var cb1 = findViewById<CheckBox>(R.id.cb1)
        var cb2 = findViewById<CheckBox>(R.id.cb2)
        var cb3 = findViewById<CheckBox>(R.id.cb3)
        var cb4 = findViewById<CheckBox>(R.id.cb4)

        var btnNext2 = findViewById<Button>(R.id.btnNext2)

        //Make it work
        var totalCounter = 0

        //Radio Group Value Calc
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        var rbValue = 0


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedId = radioGroup.checkedRadioButtonId

            rbValue = when (selectedId) {
                R.id.rb1 -> 10
                R.id.rb2 -> 20
                R.id.rb3 -> 30
                R.id.rb4 -> 40
                else -> 0
            }

        }

        //Seek Bar

        var seekValue = 0 // store the current value

        seek1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekValue = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not needed unless you want to do something when user starts dragging
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not needed unless you want to do something when user stops dragging
            }
        })

        //Switch

        var switchValue = 0

        switch1.setOnCheckedChangeListener { _, isChecked ->
            switchValue = if (isChecked) 100 else 0
        }

        //Checkboxuzzzz

        var cbTotal = 0

        val updateTotal = {
            cbTotal = 0
            if (cb1.isChecked) cbTotal += 15
            if (cb2.isChecked) cbTotal += 15
            if (cb3.isChecked) cbTotal += 15
            if (cb4.isChecked) cbTotal += 15
        }

        cb1.setOnCheckedChangeListener { _, _ -> updateTotal() }
        cb2.setOnCheckedChangeListener { _, _ -> updateTotal() }
        cb3.setOnCheckedChangeListener { _, _ -> updateTotal() }
        cb4.setOnCheckedChangeListener { _, _ -> updateTotal() }


        //Clicking on NEXT

        btnNext2.setOnClickListener {
            // Adds up  the totals
            totalCounter = rbValue + seekValue + switchValue + cbTotal

            val intent = Intent(this, MainActivity3::class.java)

            // Pass totalCounter and userName
            intent.putExtra("TOTAL_SCORE", totalCounter)
            intent.putExtra("USER_NAME", userName)

            startActivity(intent)
        }





    }




}


