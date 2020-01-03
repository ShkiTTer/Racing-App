package com.example.racingapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityLoginBinding
import com.example.racingapp.domain.entity.user.UserRole
import com.example.racingapp.presentation.common.Constants
import com.example.racingapp.presentation.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.dialog_select_role.*
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

        binding.tvReg.setOnClickListener {
            createDialog().show()
        }
    }

    private fun createDialog(): AlertDialog {
        val view = layoutInflater.inflate(R.layout.dialog_select_role, null, false)

        view.apply {
            spRole.adapter = ArrayAdapter(
                this@LoginActivity,
                R.layout.item_spinner,
                loginViewModel.userRoles
            )
        }

        return AlertDialog.Builder(this)
            .setView(view)
            .setTitle(R.string.dialog_select_role_title)
            .setNegativeButton(R.string.dialog_negative_btn, null)
            .setPositiveButton(R.string.dialog_positive_btn) { dialog, which ->
                val intent = Intent(this, RegistrationActivity::class.java).apply {
                    putExtra(Constants.EXTRA_ROLE, view.spRole.selectedItem as UserRole)
                }
                startActivity(intent)
            }.create()
    }
}
