package com.example.racingapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

        binding.apply {
            lifecycleOwner = this@ProfileActivity
            user = AllData.selectedUser ?: AllData.currentUser
        }
    }

    override fun onDestroy() {
        AllData.selectedUser = null
        super.onDestroy()
    }
}
