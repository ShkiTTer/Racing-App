package com.example.racingapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityTeamResultBinding
import com.example.racingapp.presentation.adapter.TeamResultAdapter
import com.example.racingapp.presentation.adapter.common.OnItemClickListener

class TeamResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamResultBinding
    private val adapter = TeamResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_result)

        binding.apply {
            lifecycleOwner = this@TeamResultActivity
            user = AllData.currentUser
            race = AllData.currentRace
        }

        setupList()
    }

    private fun setupList() {
        binding.rvTeamResult.adapter = adapter
        adapter.setItems(listOf())
        adapter.setListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {

            }
        })
    }
}
