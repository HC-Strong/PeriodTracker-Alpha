package com.example.periodtracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.periodtracker.R
import com.example.periodtracker.model.PeriodInfo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun goToTesting(view: View){
        var testingIntent = Intent(this, TestingActivity::class.java)
        startActivity(testingIntent)
    }

    fun onAddPeriodClick(view: View){
        var myPeriod = PeriodInfo(PeriodInfo.Flow.HEAVY)

        Log.d("TAG", "Period logged. It is ${myPeriod.flow.toString().toLowerCase()}")
    }
}
