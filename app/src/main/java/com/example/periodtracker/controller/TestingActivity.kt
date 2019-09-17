package com.example.periodtracker.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.periodtracker.R
import com.example.periodtracker.classes.Cycle

class TestingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)

        testStuff()
    }

    fun testStuff(){
        var startNumber = 6
        var startNum = startNumber

        var testCycle = Cycle(startNum, 14)

        Log.d("TAG","cycle started on ${testCycle.start}")
        Log.d("TAG", "cycle ended on ${testCycle.end}")

        startNumber = 27 // well it's not using the changed startNumber
        // and the second time I print the start date it's the same
        // so clearly it's just pulling the variable's value, not creating a ref to the place in memory

        Log.d("TAG","NOW, cycle started on ${testCycle.start}")
    }
}
