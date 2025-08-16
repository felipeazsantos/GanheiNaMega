package dev.felipeazsantos.ganheinamega

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNumber: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate : Button = findViewById(R.id.btn_generate)

        btnGenerate.setOnClickListener{
            numberGenerator(editNumber.text.toString(), txtResult)
        }
    }

    private fun numberGenerator(text: String, textResult: TextView) {
        if (text.isNotEmpty()) {
            val number = text.toInt()
            if (number < 6 || number > 15) {
                Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
                return
            }

            val numbers = mutableSetOf<Int>()
            val random = Random()

            while(true) {
                val numberGenerated = random.nextInt(60)
                numbers.add(numberGenerated + 1)

                if (numbers.size == number) {
                    break
                }
            }

            textResult.text = numbers.joinToString(" - ")
        } else {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
        }
    }

}