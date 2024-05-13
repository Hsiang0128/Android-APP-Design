package com.example.homework3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework3.R

class Page2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        findViewById<Button>(R.id.BUTTON_NEXT).setOnClickListener {
            // 创建意图对象，指定当前活动和目标活动
            val intent = Intent(this, Page3Activity::class.java)
            // 启动目标活动
            startActivity(intent)
        }
    }
}