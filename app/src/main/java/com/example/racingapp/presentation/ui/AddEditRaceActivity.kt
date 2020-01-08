package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Track
import kotlinx.android.synthetic.main.activity_add_edit_race.*

class AddEditRaceActivity : AppCompatActivity() {

    private val race = AllData.currentRace

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_race)

        fillFields()

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val cntLaps = etLaps.text.toString().toInt()
            val track = spTrack.selectedItem as Track

            if (race == null) {
                AllData.currentTournament?.addRace(Race(title, track, cntLaps))
            }
            else race.update(title, track, cntLaps)

            finish()
        }
    }

    private fun fillFields() {
        spTrack.adapter = ArrayAdapter(this, R.layout.item_spinner, AllData.tracks)

        race ?: return

        etTitle.setText(race.title)
        etLaps.setText(race.cntLaps.toString())
        spTrack.setSelection(AllData.tracks.indexOf(race.track))
    }
}
