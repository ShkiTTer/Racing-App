package com.example.racingapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.user.Manager
import com.example.racingapp.domain.entity.user.Racer
import kotlinx.android.synthetic.main.activity_add_edit_team.*

class AddEditTeamActivity : AppCompatActivity() {

    private val team = AllData.currentTeam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_team)

        fillFields()

        btnNewManager.setOnClickListener {
            val intent = Intent(this, AddManagerActivity::class.java)
            startActivity(intent)
        }

        btnNewRacer.setOnClickListener {
            val intent = Intent(this, AddRacerActivity::class.java)
            startActivity(intent)
        }

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val country = etCountry.text.toString()
            val firstRacer = spFirstRacer.selectedItem as Racer
            val secondRacer = spSecondRacer.selectedItem as Racer
            val manager = spManager.selectedItem as Manager


            if (team == null) {
                AllData.teams.add(Team(title, country, listOf(firstRacer, secondRacer), manager))
            }
            else team.update(title, country, listOf(firstRacer, secondRacer), manager)

            firstRacer.apply {
                setTeam(team ?: AllData.teams.last())
            }

            secondRacer.apply {
                setTeam(team ?: AllData.teams.last())
            }

            manager.setTeam(team ?: AllData.teams.last())

            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        fillFields()
    }

    private fun fillFields() {
        initSpinners()

        team ?: return

        spFirstRacer.setSelection(AllData.racers.indexOf(team.racers[0]))
        spSecondRacer.setSelection(AllData.racers.indexOf(team.racers[1]))
        spManager.setSelection(AllData.managers.indexOf(team.manager))

        etTitle.setText(team.title)
        etCountry.setText(team.country)
    }

    private fun initSpinners() {
        spFirstRacer.adapter = ArrayAdapter(this, R.layout.item_spinner, AllData.racers.filter { it.team == null })
        spSecondRacer.adapter = ArrayAdapter(this, R.layout.item_spinner, AllData.racers.filter { it.team == null })
        spManager.adapter = ArrayAdapter(this, R.layout.item_spinner, AllData.managers.filter { it.team == null })
    }
}
