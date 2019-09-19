package com.example.periodtracker.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.periodtracker.R
import com.example.periodtracker.classes.Cycle
import com.example.periodtracker.classes.P0

class TestingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)

        testStuff()
    }

    fun testStuff(){
        var startDate = P0(2019, 9, 7)
        // using my own P0 which is basically a LocalDate cause it's mutable

        var testCycle = Cycle(startDate, 14)

        Log.d("TAG","cycle started on ${testCycle.start.dayOfMonth}")
        Log.d("TAG", "cycle ended on ${testCycle.end}")

        startDate.dayOfMonth = 11 // did this change it?

        Log.d("TAG","NOW, cycle started on ${testCycle.start.dayOfMonth}")
    }
}
