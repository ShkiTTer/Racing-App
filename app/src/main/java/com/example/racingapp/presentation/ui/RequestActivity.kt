package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRequestBinding
import com.example.racingapp.domain.entity.user.Administrator

class RequestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_request)

        binding.apply {
            lifecycleOwner = this@RequestActivity
            user = AllData.currentUser
            request = AllData.currentRequest
        }

        binding.btnApprove.setOnClickListener {
            (AllData.currentUser as Administrator).aproveRequest(AllData.currentRequest!!)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            (AllData.currentUser as Administrator).cancelRequest(AllData.currentRequest!!)
            finish()
        }
    }

    override fun onDestroy() {
        AllData.currentRequest = null
        super.onDestroy()
    }
}
