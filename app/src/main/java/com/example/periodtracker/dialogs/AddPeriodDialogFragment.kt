package com.example.periodtracker.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.periodtracker.R
import com.example.periodtracker.utilities.BUNDLE_DIALOG
import kotlinx.android.synthetic.main.add_period_dialog.*
import kotlinx.android.synthetic.main.add_period_dialog.view.*
import java.time.LocalDate

class AddPeriodDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it, R.style.PeriodAddDialogButtons)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater

            val selectedDateStr = arguments!!.getString(BUNDLE_DIALOG)
            val selectedDate = LocalDate.parse(selectedDateStr)

            Log.d("TAG", "The selected date is $selectedDate")



            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            // (using an extra var for content to be used to set text below)
            val content = inflater.inflate(R.layout.add_period_dialog, null)
            builder.setView(content)
                // Add action buttons
                .setPositiveButton(R.string.logPeriod) { dialog, id ->
                    // log period for user ...
                    }
                .setNegativeButton(R.string.cancel) { _, _ -> dialog!!.cancel() }

            // Set text for popup to currently selected date
            content.period_date_text.text = "${selectedDate.month.toString()}  ${selectedDate.dayOfMonth.toString()}"
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

    fun prevDay(view: View) {
        Log.d("IGNORE", "Logging view to curb warnings: $view")

    }

    fun setTheText(newText: String) {
        period_date_text.text = newText
    }
}