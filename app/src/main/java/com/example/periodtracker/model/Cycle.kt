package com.example.periodtracker.model

import android.util.Log
import com.example.periodtracker.services.PeriodData
import java.time.LocalDate

// this is to store all the data about each cycle as a whole

class Cycle (val start: LocalDate, val end: LocalDate? = null){

    var dayArray = mutableListOf<DailyInfo>()
    var debug : LocalDate? = null

    fun EstimatePeriodStart(){
        Log.d("TAG", "period start estimate would go here")
    }
    fun EstimateFertility(){
        Log.d("TAG", "fertility estimate would go here")
    }

    //In the init for the Cycle object here, I set up a proof of concept for the ability to
    //modify the last cycle item in the PeriodData array when a new one is created
    init {
        Log.d("TAG", "initializing cycle...")
        val cycleCount = PeriodData.cycleRecords.count()

        if (cycleCount == 0) {
            Log.d("TAG", "No existing cycle data to update. Creating new cycle and moving on")
        } else {
            Log.d("TAG", "Currently there are $cycleCount cycle records")
            Log.d("TAG", "Debug is ${PeriodData.cycleRecords[cycleCount-1].debug.toString()}.")
            PeriodData.cycleRecords[cycleCount-1].debug = start
            Log.d("TAG", "Now it's ${PeriodData.cycleRecords[cycleCount-1].debug.toString()}. Hope that's changed.")
        }
    }
}