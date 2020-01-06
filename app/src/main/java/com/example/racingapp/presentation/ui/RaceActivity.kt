package com.example.racingapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRaceBinding

class RaceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_race)

        binding.apply {
            lifecycleOwner = this@RaceActivity
            user = AllData.currentUser
        }

        binding.btnTeamResults.setOnClickListener {
            val intent = Intent(this, TeamResultActivity::class.java)
            startActivity(intent)
        }

        binding.btnRacerResults.setOnClickListener {
            val intent = Intent(this, RacerResultActivity::class.java)
            startActivity(intent)
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddEditRaceActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.race = AllData.currentRace
    }

    override fun onDestroy() {
        AllData.currentRace = null
        super.onDestroy()
    }
}
