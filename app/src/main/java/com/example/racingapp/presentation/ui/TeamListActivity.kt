package com.example.racingapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRaceListBinding
import com.example.racingapp.databinding.ActivityTeamListBinding
import com.example.racingapp.presentation.adapter.RaceAdapter
import com.example.racingapp.presentation.adapter.TeamAdapter
import com.example.racingapp.presentation.adapter.common.OnItemClickListener

class TeamListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamListBinding
    private val adapter = TeamAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_list)

        binding.apply {
            lifecycleOwner = this@TeamListActivity
            user = AllData.currentUser
            tournament = AllData.currentTournament
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddEditTeamActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setupList()
    }

    private fun setupList() {
        binding.rvTeams.adapter = adapter
        adapter.setItems(AllData.currentTournament?.teams ?: AllData.teams)
        adapter.setListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                AllData.currentTeam = AllData.teams[position]

                val intent = Intent(this@TeamListActivity, TeamActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
