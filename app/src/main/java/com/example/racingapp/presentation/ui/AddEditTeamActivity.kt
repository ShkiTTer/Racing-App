package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.user.Racer
import kotlinx.android.synthetic.main.activity_add_edit_team.*

class AddEditTeamActivity : AppCompatActivity() {

    private val team = AllData.currentTeam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_team)

        fillFields()

        racers.visibility = if (team == null) View.VISIBLE else View.GONE

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val country = etCountry.text.toString()
            val firstRacer = spFirstRacer.selectedItem as Racer
            val secondRacer = spSecondRacer.selectedItem as Racer

            if (team == null) {
                AllData.teams.add(Team(title, country, listOf(firstRacer, secondRacer)))
            }
            else team.apply {
                this.title = title
                this.country = country
            }

            finish()
        }
    }

    private fun fillFields() {
        team ?: return

        spFirstRacer.adapter = ArrayAdapter(this, R.layout.item_spinner, team.racers)
        spSecondRacer.adapter = ArrayAdapter(this, R.layout.item_spinner, team.racers)
        spFirstRacer.setSelection(0)
        spSecondRacer.setSelection(1)

        etTitle.setText(team.title)
        etCountry.setText(team.country)
    }
}
