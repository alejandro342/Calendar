package com.alejandro.calendar.view.calendar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alejandro.calendar.databinding.ActivityCalendarBinding
import com.alejandro.calendar.date.DateFragment

class CalendarActivity : AppCompatActivity(), View.OnClickListener {
    var mBinding: ActivityCalendarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCalendarBinding.inflate(layoutInflater)
        val mView: View = mBinding!!.root
        setContentView(mView)
        mBinding!!.etDate.setOnClickListener(this)
    }

    private fun showDateDialog() {//mostrar calendario inicializamos el DateFragmen
        val dateCalendar = DateFragment { day, month, year -> onDateSelectd(day, month, year) }//recibimos la variables dy/month/year
        dateCalendar.show(supportFragmentManager, "dateCalendar")
    }

    @SuppressLint("SetTextI18n")
    fun onDateSelectd(day: Int, month: Int, year: Int) {//pintamos la fecha en el Editext
        mBinding!!.etDate.setText("Fecha: $day/$month/$year")
    }

    override fun onClick(mItem: View?) {
        when (mItem) {
            mBinding!!.etDate -> showDateDialog()
        }
    }

}