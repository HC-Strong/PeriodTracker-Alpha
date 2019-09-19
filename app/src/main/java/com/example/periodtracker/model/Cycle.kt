package com.example.periodtracker.model

import android.util.Log
import java.time.LocalDate

// this is to store all the data about each cycle as a whole

class Cycle (val start: LocalDate, val end: LocalDate?, var dateArray: Array<DailyInfo>){

    fun EstimatePeriodStart(){
        Log.d("TAG", "period start estimate would go here")
    }
    fun EstimateFertility(){
        Log.d("TAG", "fertility estimate would go here")
    }

}