package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRegistrationBinding
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
        println(viewModel.userRole.value)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)

        binding.apply {
            lifecycleOwner = this@RegistrationActivity
        }

        binding.tvBack.setOnClickListener {
            finish()
        }
    }
}
