package com.alejandro.calendar.date

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.alejandro.calendar.R
import java.util.Calendar

//recibir una funcion con parametros para pasar valores al ejecutarse
class DateFragment(val listener: (day: Int, month: Int, year: Int) -> Unit) : DialogFragment(),
    //escuchador para cuando se seleccione una fecha en el calendario
    DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        listener(day, month, year) //valores a obtener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH) //dei del mes
        val month = c.get(Calendar.MONTH)//mes
        val year = c.get(Calendar.YEAR)//año

        //mostrar el calendario al usuario
        val picker =
            DatePickerDialog(activity as Context, R.style.Theme_MyCalendar, this, year, month, day)
        picker.datePicker.minDate = c.timeInMillis
        return picker
    }
}