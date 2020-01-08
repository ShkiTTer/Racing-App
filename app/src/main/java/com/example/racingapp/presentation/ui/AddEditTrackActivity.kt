package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.Track
import kotlinx.android.synthetic.main.activity_add_edit_track.*

class AddEditTrackActivity : AppCompatActivity() {

    private val track = AllData.currentTrack

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_track)

        fillFields()

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val country = etCountry.text.toString()
            val length = etLength.text.toString().toInt()

            if (track == null) {
                AllData.tracks.add(Track(title, country, length))
            }
            else track.update(title, country, length)

            finish()
        }
    }

    private fun fillFields() {
        etTitle.setText(track?.title)
        etCountry.setText(track?.country)
        etLength.setText(track?.length?.toString())
    }

    override fun onDestroy() {
        AllData.currentTrack = null
        super.onDestroy()
    }
}
