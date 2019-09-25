package com.example.periodtracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.periodtracker.R
import com.example.periodtracker.model.Cycle
import com.example.periodtracker.model.PeriodInfo
import com.example.periodtracker.services.PeriodData
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun goToTesting(view: View){
        val testingIntent = Intent(this, TestingActivity::class.java)
        startActivity(testingIntent)
    }

    fun onAddPeriodClick(view: View){
        //var myPeriod = PeriodInfo(PeriodInfo.Flow.HEAVY)
        //Log.d("TAG", "Period logged. It is ${myPeriod.flow.toString().toLowerCase()}")

        val newCycle = Cycle(LocalDate.of(2019, 9, 24))

        Log.d("TAG", PeriodData.cycleRecords.toString())
        PeriodData.cycleRecords.add(newCycle)
        Log.d("TAG", PeriodData.cycleRecords.toString())
    }
}
