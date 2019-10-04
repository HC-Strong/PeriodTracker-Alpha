package com.example.periodtracker.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.periodtracker.R
import com.example.periodtracker.utilities.BUNDLE_DIALOG
import kotlinx.android.synthetic.main.add_period_dialog.*
import kotlinx.android.synthetic.main.add_period_dialog.view.*
import java.time.LocalDate

class AddPeriodDialogFragment : DialogFragment() {

    private var selectedDate = LocalDate.now()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it, R.style.PeriodAddDialogButtons)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater

            val selectedDateStr = arguments!!.getString(BUNDLE_DIALOG)
            selectedDate = LocalDate.parse(selectedDateStr)

            Log.d("TAG", "The selected date is $selectedDate")



            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            // (using an extra var for content to be used to set text and onclicklisteners below!!!!!)
            val content = inflater.inflate(R.layout.add_period_dialog, null)
            builder.setView(content)
                // Add action buttons
                .setPositiveButton(R.string.logPeriod) { dialog, id ->
                    // log period for user ...
                    }
                .setNegativeButton(R.string.cancel) { _, _ -> dialog!!.cancel() }

            // Set text for popup to currently selected date
            content.period_date_text.text = "${selectedDate.month.toString()}  ${selectedDate.dayOfMonth.toString()}"

            content.prevBtn.setOnClickListener { view -> prevDay(view, content.period_date_text) }


                builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

    private fun prevDay(view: View, dateText: TextView) {
        Log.d("IGNORE", "Logging view to curb warnings: $view")

        val oldDate = selectedDate
        val newDate = oldDate.minusDays(1)
        dateText.text = "${newDate.month.toString()}  ${newDate.dayOfMonth.toString()}"
        Log.d("TAG", "success in the prevDay clicking department!")
    }
}