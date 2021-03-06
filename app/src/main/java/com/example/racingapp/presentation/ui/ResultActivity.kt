package com.example.racingapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityResultBinding
import com.example.racingapp.presentation.adapter.ResultAdapter

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private val adapter = ResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)

        binding.apply {
            lifecycleOwner = this@ResultActivity
            user = AllData.currentUser
            race = AllData.currentRace
            isRacer = AllData.racerResult
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddResultActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setupList()
    }

    private fun setupList() {
        binding.rvResult.adapter = adapter

        if (AllData.currentRace == null) {
            adapter.setItems(if (AllData.racerResult) AllData.currentTournament!!.racerResults else AllData.currentTournament!!.teamResults)
        } else {
            adapter.setItems(if (AllData.racerResult) AllData.currentRace!!.racerResults else AllData.currentRace!!.teamResults)
        }
    }
}
