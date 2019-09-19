package com.example.periodtracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.periodtracker.R
import com.example.periodtracker.model.CycleOld
import com.example.periodtracker.model.P0

class TestingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)

        testStuff()
    }

    fun testStuff(){
        var startDate = P0(2019, 9, 7)
        // using my own P0 which is basically a LocalDate cause it's mutable

        var testCycle = CycleOld(startDate, 14)

        Log.d("TAG","cycle started on ${testCycle.start.dayOfMonth}")
        Log.d("TAG", "cycle ended on ${testCycle.end}")

        startDate.dayOfMonth = 11

        Log.d("TAG","NOW, cycle started on ${testCycle.start.dayOfMonth}")
    }

    fun goToExample(view: View){
        var exampleIntent = Intent(this, exBasicActivity::class.java)
        startActivity(exampleIntent)
    }
}
