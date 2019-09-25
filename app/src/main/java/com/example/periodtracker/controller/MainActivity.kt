package com.example.periodtracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.get
import com.example.periodtracker.R
import com.example.periodtracker.model.Cycle
import com.example.periodtracker.model.PeriodInfo
import com.example.periodtracker.services.PeriodData
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.util.*
import java.util.Calendar.DAY_OF_MONTH

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

        //Log.d("TAG", mainCalendarView.get(Calendar.DAY_OF_MONTH).toString())
        Log.d("TAG", "It is ${mainCalendarView.date.to(DAY_OF_MONTH)}.") // This is NOT returning what I'd expect but at least it's not breaking the app like other attempts

        val newCycle = Cycle(LocalDate.of(2019, 9, 24))

        Log.d("TAG", PeriodData.cycleRecords.toString())
        PeriodData.cycleRecords.add(newCycle)
        Log.d("TAG", PeriodData.cycleRecords.toString())
    }
}
