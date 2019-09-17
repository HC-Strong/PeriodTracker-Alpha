package com.example.periodtracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.periodtracker.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun goToTesting(view: View){
        var testingIntent = Intent(this, TestingActivity::class.java)
        startActivity(testingIntent)
    }
}
