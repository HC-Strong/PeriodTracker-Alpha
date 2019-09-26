package com.example.periodtracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import com.example.periodtracker.R
import com.example.periodtracker.model.Cycle
import com.example.periodtracker.services.PeriodData
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDate.now
import java.util.Calendar.DAY_OF_MONTH

class MainActivity : AppCompatActivity() {

    var curSelectedDate : LocalDate = LocalDate.of(now().year, now().month, now().dayOfMonth)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calendarView = findViewById<CalendarView>(R.id.mainCalendarView)


        calendarView?.setOnDateChangeListener {_, year,month,day ->
            val dateAsString : String = "" + (month+1) + "/" + day + "/" + year
            curSelectedDate = LocalDate.of(year, month, day)
            Toast.makeText(this,dateAsString, Toast.LENGTH_SHORT).show()
        }


    }


    fun goToTesting(view: View){
        Log.d("Nothing", "The view is $view")
        val testingIntent = Intent(this, TestingActivity::class.java)
        startActivity(testingIntent)
    }

    fun onAddPeriodClick(view: View){
        Log.d("Nothing", "The view is $view")
        // When button is clicked, create new cycle starting on currently selected date
        // the selected date is stored in a

        Toast.makeText(this,curSelectedDate.toString(), Toast.LENGTH_SHORT).show()


            ///////////////////////////////////////////////////
        val newCycle = Cycle(LocalDate.of(2019, 9, 24))

        Log.d("TAG", PeriodData.cycleRecords.toString())
        PeriodData.cycleRecords.add(newCycle)
        Log.d("TAG", PeriodData.cycleRecords.toString())
    }
}
