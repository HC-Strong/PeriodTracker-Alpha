package com.example.periodtracker.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import com.example.periodtracker.R
import com.example.periodtracker.adapters.CalendarUpdate
import com.example.periodtracker.dialogs.AddPeriodDialogFragment
import com.example.periodtracker.model.Cycle
import com.example.periodtracker.services.PeriodData
import com.example.periodtracker.utilities.BUNDLE_DIALOG
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_testing.view.*
import kotlinx.android.synthetic.main.calendar_dates_default.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDate.now
import java.util.Calendar.DAY_OF_MONTH

class MainActivity : AppCompatActivity() {

    var curSelectedDate : LocalDate = LocalDate.of(now().year, now().month, now().dayOfMonth)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//code for old calendar
/*        val calendarView = findViewById<CalendarView>(R.id.mainCalendarView)
        calendarView?.setOnDateChangeListener {_, year,month,day ->
            curSelectedDate = LocalDate.of(year, month, day)
            Toast.makeText(this,curSelectedDate.toString(), Toast.LENGTH_SHORT).show()
        }*/

        CalendarUpdate().updateCalendar(this, calendar_grid, now())


    }


    fun goToTesting(view: View){
        Log.d("IGNORE", "Logging view to curb warnings: $view")
        val testingIntent = Intent(this, TestingActivity::class.java)
        startActivity(testingIntent)
    }

    fun onAddPeriodClick(view: View){
        Log.d("IGNORE", "Logging view to curb warnings: $view")

        Toast.makeText(this,curSelectedDate.toString(), Toast.LENGTH_SHORT).show()

        logPeriodDialog(view)

        ///////////////////////////////////////////////////
        ///create period data for that date and also create cycle if no period on prev day


        val newCycle = Cycle(LocalDate.of(curSelectedDate.year, curSelectedDate.month+1, curSelectedDate.dayOfMonth))

        Log.d("TAG", PeriodData.cycleRecords.toString())
        PeriodData.cycleRecords.add(newCycle)
        Log.d("TAG", PeriodData.cycleRecords.toString())
    }

    fun logPeriodDialog(view: View) {
        Log.d("IGNORE", "Logging view to curb warnings: $view")

        val logPeriodBundle = Bundle()
        lateinit var dateString : String

        // Any date view will have that calendarDateTxtView in it to work with, but the FAB won't
        if ( view.calendarDateTxtView != null ) {
            dateString = "${view.getTag(R.id.hidden_date_info_tag_id).toString()} ${view.calendarDateTxtView.text.toString()}"
        } else {
            dateString = now().month.toString()+" "+ now().dayOfMonth.toString()
        }


        logPeriodBundle.putString(BUNDLE_DIALOG, dateString)

        val newFragment = AddPeriodDialogFragment()
        newFragment.arguments = logPeriodBundle
        newFragment.show(supportFragmentManager, "add period")
    }
}
