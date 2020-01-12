package com.example.racingapp.presentation.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.Result
import com.example.racingapp.domain.entity.user.Racer
import kotlinx.android.synthetic.main.activity_add_result.*

class AddResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_result)

        spRacer.adapter = ArrayAdapter(
            this,
            R.layout.item_spinner,
            AllData.currentTournament!!.getRacers().filter {
                !AllData.currentRace!!.racerResults.any { result -> result.subject == it }
            })

        btnSave.setOnClickListener {
            val racer = spRacer.selectedItem as Racer
            val place = etPlace.text.toString().toInt()
            val points = etPoints.text.toString().toInt()

            AllData.currentRace?.addRacerResult(RacerResult(racer, place, points))

            finish()
        }
    }
}
