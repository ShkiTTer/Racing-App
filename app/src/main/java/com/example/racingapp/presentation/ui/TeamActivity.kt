package com.example.racingapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityTeamBinding

class TeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team)

        binding.apply {
            lifecycleOwner = this@TeamActivity
            user = AllData.currentUser
            team = AllData.currentTeam
            rvRacers.adapter = ArrayAdapter(this@TeamActivity, android.R.layout.simple_list_item_1, AllData.currentTeam!!.racers)
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddEditTeamActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.team = AllData.currentTeam
    }

    override fun onDestroy() {
        AllData.currentTeam = null
        super.onDestroy()
    }
}
