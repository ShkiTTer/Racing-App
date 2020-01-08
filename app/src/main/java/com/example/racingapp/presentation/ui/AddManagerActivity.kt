package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.user.Manager
import kotlinx.android.synthetic.main.activity_add_manager.*

class AddManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_manager)

        btnSave.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPassword.text.toString()
            val name = etName.text.toString()
            val surname = etSurname.text.toString()

            AllData.users.add(Manager(login, password, name, surname))

            finish()
        }
    }
}
