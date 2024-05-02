package com.example.bmi_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmi_app.ui.theme.BMI_APPTheme
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.widget.TextView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Button_Input = findViewById<Button>(R.id.BUTTON_INPUT)
        Button_Input.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val Button_Info = findViewById<Button>(R.id.BUTTON_INFO)
        Button_Info.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        val bundle = intent.extras // 获取从发送方 Activity 传递过来的 Bundle
        if (bundle != null) {
            findViewById<TextView>(R.id.LABEL_NAME).text =
                "Name: ${bundle.getString("NAME")}"
            findViewById<TextView>(R.id.LABEL_GENDA).text =
                "Genda: ${bundle.getString("GENDA")}"
            findViewById<TextView>(R.id.LABEL_BMI_VALUE).text =
                "BMI Value: ${bundle.getString("BMI")}"
            findViewById<TextView>(R.id.LABEL_STATUS).text =
                "Status: ${bundle.getString("STATUS")}"
        }
    }
}
