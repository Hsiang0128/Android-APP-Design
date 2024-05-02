package com.example.bmi_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        val pageAdapter = ScreenSlidePagerAdapter(this)
        //link Adapter，create linkage among Fragments and ViewPager
        val viewPager = findViewById <ViewPager2> (R.id.VIEW_PAGER)
        viewPager.adapter = pageAdapter
        val Button_Back = findViewById<Button>(R.id.BUTTON_BACK)
        Button_Back.setOnClickListener {
            finish()
        }
    }
}
class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int) = when(position) {
        0 -> FirstFragment()     //First Fragment
        1 -> SecondFragment()    //Second Fragment
        else -> ThirdFragment()  //Third Fragment
    }
    //return the numbers of Fragment
    override fun getItemCount() = 3
}