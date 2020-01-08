package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.tournament.Tournament
import com.example.racingapp.domain.entity.user.Manager
import kotlinx.android.synthetic.main.activity_add_request.*

class AddRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_request)

        tvTeam.text = AllData.myTeam?.title
        spTournament.adapter = ArrayAdapter(this, R.layout.item_spinner, AllData.tournaments.filter { !it.teams.contains(AllData.myTeam) })

        btnSave.setOnClickListener {
            val tournament = spTournament.selectedItem as Tournament
            (AllData.currentUser as Manager).createRequest(tournament)

            finish()
        }
    }
}
