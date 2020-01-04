package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityTrackListBinding
import com.example.racingapp.presentation.adapter.TrackAdapter
import com.example.racingapp.presentation.adapter.common.OnItemClickListener

class TrackListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackListBinding
    private val adapter = TrackAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_track_list)

        binding.apply {
            lifecycleOwner = this@TrackListActivity
            user = AllData.currentUser
        }

        setupList()
    }

    private fun setupList() {
        binding.rvTrack.adapter = adapter
        adapter.setItems(AllData.tracks)
        adapter.setListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {

            }
        })
    }
}
