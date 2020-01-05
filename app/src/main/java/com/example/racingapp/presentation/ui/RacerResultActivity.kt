package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRacerResultBinding
import com.example.racingapp.presentation.adapter.TeamResultAdapter
import com.example.racingapp.presentation.adapter.common.OnItemClickListener

class RacerResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRacerResultBinding
    private val adapter = TeamResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_racer_result)

        binding.apply {
            lifecycleOwner = this@RacerResultActivity
            user = AllData.currentUser
            race = AllData.currentRace
        }

        setupList()
    }

    private fun setupList() {
        binding.rvRacerResult.adapter = adapter
        adapter.setItems(listOf())
        adapter.setListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {

            }
        })
    }
}
