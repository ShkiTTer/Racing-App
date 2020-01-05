package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.tournament.Tournament
import com.example.racingapp.domain.entity.tournament.TournamentState
import com.example.racingapp.domain.entity.tournament.TournamentType
import kotlinx.android.synthetic.main.activity_add_edit_tournament.*

class AddEditTournamentActivity : AppCompatActivity() {

    private val tournament = AllData.currentTournament

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_tournament)

        fillFields()

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val type = spType.selectedItem as TournamentType
            val state = spState.selectedItem as TournamentState

            if (tournament == null) {
                AllData.tournaments.add(Tournament(title, type, state))
            }
            else tournament.apply {
                this.title = title
                this.type = type
                this.state = state
            }

            finish()
        }
    }

    private fun fillFields() {
        spType.adapter = ArrayAdapter(this, R.layout.item_spinner, TournamentType.values())
        spState.adapter = ArrayAdapter(this, R.layout.item_spinner, TournamentState.values())

        tournament ?: return

        etTitle.setText(tournament.title)
        spType.setSelection(TournamentType.values().indexOf(tournament.type))
        spState.setSelection(TournamentState.values().indexOf(tournament.state))
    }
}
