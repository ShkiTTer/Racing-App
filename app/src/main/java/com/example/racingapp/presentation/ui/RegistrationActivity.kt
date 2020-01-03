package com.example.racingapp.presentation.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRegistrationBinding
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.user.UserRole
import com.example.racingapp.presentation.common.Constants
import com.example.racingapp.presentation.viewmodel.RegistrationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private val viewModel by viewModel<RegistrationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.userRole.value = intent.getSerializableExtra(Constants.EXTRA_ROLE) as UserRole

        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)

        binding.apply {
            lifecycleOwner = this@RegistrationActivity
            userRole = viewModel.userRole
            spTeam.adapter = ArrayAdapter(this@RegistrationActivity, R.layout.item_spinner, AllData.teams)
        }

        binding.tvBack.setOnClickListener {
            finish()
        }

        binding.btnSignUp.setOnClickListener {
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()
            val team = if (binding.spTeam.selectedItem == null) null else binding.spTeam.selectedItem as Team

            if (password != confirmPassword || login.isEmpty() || password.isEmpty()) return@setOnClickListener

            when (viewModel.userRole.value) {
                UserRole.MANAGER -> viewModel.createManager(login, password, team!!)
                UserRole.ADMINISTRATOR -> viewModel.createAdmin(login, password)
                UserRole.RACER -> viewModel.createRacer(login, password, team!!)
            }

            finish()
        }
    }
}
