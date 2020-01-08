package com.example.racingapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityLoginBinding
import com.example.racingapp.domain.entity.user.UserRole
import com.example.racingapp.presentation.common.Constants
import com.example.racingapp.presentation.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.dialog_select_role.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.apply {
            lifecycleOwner = this@LoginActivity
        }

        binding.btnSignIn.setOnClickListener {
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()

            val user = AllData.users.find { it.login == login && it.password == password }
                ?: return@setOnClickListener

            AllData.currentUser = user

            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
