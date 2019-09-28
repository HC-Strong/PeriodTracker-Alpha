package com.example.periodtracker.adapters

import android.content.Context
import android.util.Log
import android.widget.GridView
import android.widget.Toast
import com.example.periodtracker.services.PeriodData
import java.time.LocalDate

class CalendarUpdate {
    fun updateCalendar(context: Context, gridView: GridView, refDate: LocalDate) {

        val gridDates = mutableListOf<LocalDate>()

        val startOffset = LocalDate.of(refDate.year, refDate.month, 1).dayOfWeek.value-1
        Log.d("TAG", "start day of week is $startOffset")

        val daysInMonth = refDate.lengthOfMonth()
        Toast.makeText(context, "there are $daysInMonth days in the current month", Toast.LENGTH_LONG).show()

        // Fill in days from prev month
        val prevMonth = refDate.minusMonths(1)
        val daysInPrevMonth = prevMonth.lengthOfMonth()

        if(startOffset > 0) {
            for (i in daysInPrevMonth-startOffset+1..daysInPrevMonth) {
                gridDates.add(LocalDate.of(prevMonth.year, prevMonth.month, i))
            }
        }

        // Fill in days in current month
        var j = 1
        while (j <= daysInMonth) {
            gridDates.add(LocalDate.of(refDate.year, refDate.month, j))
            j++
        }


        // Fill in days in next month
        val daysOnLastRow = gridDates.count().rem(7)
        val nextMonth = refDate.plusMonths(1)

        if(gridDates.count() < 7*6 && daysOnLastRow != 0) {
            val daysToFill = 7 - daysOnLastRow
            for (k in 1..daysToFill) {
                gridDates.add(LocalDate.of(nextMonth.year, nextMonth.month, k))
            }
        } else {
            Log.d("TAG", "No need to fill in next month dates")
        }


        Log.d("TAG", "The date array is: $gridDates")

        // old default adapter in case I want to go back:
        //val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, gridDates)
        //gridView.adapter = adapter


        // set gridView Adapter
        val adapter = CalendarAdapter(context, gridDates, PeriodData.periodRecords)
        gridView.adapter = adapter
    }
}