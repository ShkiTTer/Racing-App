package com.example.racingapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRaceListBinding
import com.example.racingapp.presentation.adapter.RaceAdapter
import com.example.racingapp.presentation.adapter.common.OnItemClickListener

class RaceListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRaceListBinding
    private val adapter = RaceAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_race_list)

        binding.apply {
            lifecycleOwner = this@RaceListActivity
            user = AllData.currentUser
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddEditRaceActivity::class.java)
            startActivity(intent)
        }

        setupList()
    }

    private fun setupList() {
        binding.rvRaces.adapter = adapter
        adapter.setItems(AllData.currentTournament!!.races)
        adapter.setListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                AllData.currentRace = AllData.currentTournament?.races?.get(position)
                val intent = Intent(this@RaceListActivity, RaceActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
