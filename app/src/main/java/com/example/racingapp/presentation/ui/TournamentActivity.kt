package com.example.racingapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityTournamentBinding
import com.example.racingapp.presentation.viewmodel.TournamentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TournamentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTournamentBinding
    private val viewModel by viewModel<TournamentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tournament)

        viewModel.tournament.value = AllData.currentTournament
        viewModel.user = AllData.currentUser

        binding.apply {
            lifecycleOwner = this@TournamentActivity
            user = viewModel.user
            tournament = viewModel.tournament
        }

        binding.btnRaces.setOnClickListener {
            val intent = Intent(this, RaceListActivity::class.java)
            startActivity(intent)
        }

        binding.btnTeams.setOnClickListener {
            val intent = Intent(this, TeamListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        AllData.currentTournament = null
        super.onDestroy()
    }
}
