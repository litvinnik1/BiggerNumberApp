package com.example.biggernumberapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        val backgroundView = findViewById<ConstraintLayout>(R.id.backgroundView)

        assignNumbersToButtons()
        btnLeft.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButtons()
        }

        btnRight.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()
        }
    }
    private fun assignNumbersToButtons() {

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        val backgroundView = findViewById<ConstraintLayout>(R.id.backgroundView)

        val r = Random()
        val num1 = r.nextInt(10)
        var num2 = num1
        while (num2 == num1) {
            num2 = r.nextInt(10)
        }
        btnLeft.text = num1.toString()
        btnRight.text = num2.toString()
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        val backgroundView = findViewById<ConstraintLayout>(R.id.backgroundView)

        val n1 = btnLeft.text.toString().toInt()
        val n2 = btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) n1 > n2 else n2 > n1
        val toastMessage: String
        val backgroundColor: Int
        if (isAnswerCorrect) {
            toastMessage = "Correct!!"
            backgroundColor = Color.GREEN
        } else {
            toastMessage = "Wrong"
            backgroundColor = Color.RED
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        backgroundView.setBackgroundColor(backgroundColor)
    }
}