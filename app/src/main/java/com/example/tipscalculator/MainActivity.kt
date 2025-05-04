package com.example.tipscalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    //declarando o binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inicializando o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener {

            val totalTableTemp = binding.tieTotal.text
            val numPeopleTemp = binding.tieNumPessoas.text
            val percentageTemp = binding.tiePercentage.text

            if (totalTableTemp?.isEmpty() == true || numPeopleTemp?.isEmpty() == true || percentageTemp?.isEmpty() == true) {
                Snackbar.make(
                    binding.tieTotal,
                    "Preencha todos os campos!",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = numPeopleTemp.toString().toInt()
                val percentage: Int = percentageTemp.toString().toInt()
                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentageTemp.toString().toInt() / 100
                val totalWithTips = totalTemp + tips

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", nPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalAmount", totalWithTips)
                }
                clean()
                startActivity((intent))
            }
        }

        binding.btnClean.setOnClickListener {
            clean()
        }
    }

    private fun clean() {
        binding.tieTotal.setText("")
        binding.tiePercentage.setText("")
        binding.tieNumPessoas.setText("")


    }
}

