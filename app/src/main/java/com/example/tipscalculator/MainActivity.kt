package com.example.tipscalculator

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnDone = findViewById<Button>(R.id.btn_done)
        val btnClean = findViewById<Button>(R.id.btn_clean)
        val edtTotal = findViewById<TextInputEditText>(R.id.tie_total)
        val edtNumPeople = findViewById<TextInputEditText>(R.id.tie_num_people)

        btnDone.setOnClickListener {
            println("Total: " + edtTotal.text)
            println("Pessoas: " + edtNumPeople.text)
        }

    }
}
