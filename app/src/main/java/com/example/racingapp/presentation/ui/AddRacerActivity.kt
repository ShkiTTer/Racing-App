package com.example.racingapp.presentation.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.user.Racer
import kotlinx.android.synthetic.main.activity_add_racer.*
import java.text.SimpleDateFormat
import java.util.*

class AddRacerActivity : AppCompatActivity() {

    private val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_racer)

        etDate.setOnClickListener {
            val dialog = DatePickerDialog(this)
            val calendar = Calendar.getInstance()
            val date =
                if (etDate.text.toString().isEmpty()) null else sdf.parse(etDate.text.toString())


            if (date != null) {
                calendar.time = date
                dialog.datePicker.updateDate(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
            }

            dialog.setOnDateSetListener { view, year, month, dayOfMonth ->

                calendar.set(year, month, dayOfMonth)
                etDate.setText(sdf.format(calendar.time))
            }

            dialog.show()
        }

        btnSave.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPassword.text.toString()
            val name = etName.text.toString()
            val surname = etSurname.text.toString()
            val country = etCountry.text.toString()
            val date = sdf.parse(etDate.text.toString())!!

            AllData.users.add(Racer(login, password, name, surname, country, date))

            finish()
        }
    }
}
