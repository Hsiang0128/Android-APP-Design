package com.example.bmi_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val ButtonCalculate = findViewById<Button>(R.id.BUTTON_CALCULATE)
        ButtonCalculate.setOnClickListener {
            val nameInput = findViewById<EditText>(R.id.NAME_INPUT)
            val heightInput = findViewById<EditText>(R.id.HEIGHT_INPUT)
            val weightInput = findViewById<EditText>(R.id.WEIGHT_INPUT)
            val name = nameInput.getText().toString().trim { it <= ' ' }
            val height = heightInput.getText().toString().trim { it <= ' ' }
            val weight = weightInput.getText().toString().trim { it <= ' ' }
            val radioButtonGroup = findViewById<RadioGroup>(R.id.BUTTON_GROUP)
            val selectedRadioButtonId = radioButtonGroup.checkedRadioButtonId
            if(name.isEmpty() || height.isEmpty() || weight.isEmpty() || selectedRadioButtonId == -1){
                Toast.makeText(this, "Please Enter All Data", Toast.LENGTH_SHORT).show();
            } else {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val genda = selectedRadioButton.text.toString()

                val intent = Intent(this, MainActivity::class.java)
                val bundle = Bundle()
                val BMI_Val = ((weight.toDouble()*10000.0)/(height.toDouble()*height.toDouble()))
                val BMI = String.format("%.1f", BMI_Val).toString()
                var status = " "
                if(BMI_Val < 18.5){status = "Underweight"}
                else if(BMI_Val < 24.0){status = "Healthy"}
                else if(BMI_Val < 27.0){status = "Overweight"}
                else if(BMI_Val < 30.0){status = "Mild Obesity"}
                else if(BMI_Val < 35.0){status = "Moderate Obesity"}
                else {status = "Severe Obesity"}

                bundle.putString("NAME", name)
                bundle.putString("BMI", BMI)
                bundle.putString("STATUS", status)
                bundle.putString("GENDA", genda)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}