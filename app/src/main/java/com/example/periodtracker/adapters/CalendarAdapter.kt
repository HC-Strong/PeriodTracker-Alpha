package com.example.periodtracker.adapters

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.setTag
import com.example.periodtracker.R
import com.example.periodtracker.model.DailyInfo
import java.time.LocalDate

class CalendarAdapter( private val context: Context, private val displayDates : List<LocalDate>, private val gridDateTags : List<String>, val lookupDates: List<DailyInfo>) : BaseAdapter() {
    //val events = CalendarEventList.events

    override fun getView(position: Int, convertViewVal: View?, parent: ViewGroup?): View {
        var convertView = convertViewVal  // convertView input is val not var, can't update
        val holder : ItemHolder

        //check if current day is a period day
        val periodStatus = if(lookupDates.find {it.date == displayDates[position]} == null) 0 else 1
        //val dateStatus = events.getOrDefault(displayDates[position], 0)
        val layout = when {
            displayDates[position].month != displayDates[15].month -> R.layout.calendar_dates_inactive      // set the resource to inflate dates in non-active months
            periodStatus == 1 -> R.layout.calendar_dates_period                                   // set resource to inflate period dates
            else -> R.layout.calendar_dates_default                                             // set default resource
        }

        if (convertView == null ) {
            convertView = LayoutInflater.from(context).inflate(layout, null)
            holder = ItemHolder()
            holder.dateText = convertView!!.findViewById(R.id.calendarDateTxtView)
            convertView.tag = holder
            Log.d("TAG", "new")

        } else {
            holder = convertView.tag as ItemHolder
            Log.d("TAG", "reuse")
        }

        holder.dateText!!.text = this.displayDates[position].dayOfMonth.toString()
        holder.dateText!!.setTag(R.id.hidden_date_info_tag_id, this.gridDateTags[position])

        ////////////// MAKE ADDITIONAL CHANGES TO SPECIFIC ASPECTS OF GRID VIEWS BY UNCOMMENTING THE FOLLOWING/////
/*        if (this.dates[position].dayOfMonth > 4) {
            holder.dateText!!.setTextColor(Color.parseColor("#bdbdbd"))                       // set text color only
            holder.dateText!!.setBackgroundColor(getColor(context, R.color.colorPrimaryDark)) // set bg color
            //holder.dateText!!.setBackgroundResource((R.drawable.dark_shape))                  // set bg drawable
        }*/
        return  convertView
    }





    internal class ItemHolder {
        var dateText: TextView? = null
    }


    override fun getItem(position: Int): Any {
        return displayDates[position]
    }

    override fun getItemId(position: Int): Long {
        return 0 // won't need this, so giving it an arbitrary return value
    }

    override fun getCount(): Int {
        return displayDates.count()
    }
}