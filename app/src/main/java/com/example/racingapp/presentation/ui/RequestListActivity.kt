package com.example.racingapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityRequestListBinding
import com.example.racingapp.domain.entity.request.Request
import com.example.racingapp.presentation.adapter.RequestAdapter
import com.example.racingapp.presentation.adapter.common.OnItemClickListener

class RequestListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRequestListBinding
    private val adapter = RequestAdapter()
    private val data = mutableListOf<Request>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_request_list)

        binding.apply {
            lifecycleOwner = this@RequestListActivity
            user = AllData.currentUser
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddRequestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setupList()
    }

    private fun setupList() {
        data.clear()
        binding.rvRequests.adapter = adapter

        if (AllData.myTeam != null) {
            data.addAll(AllData.myTeam!!.requests)
        } else {
            AllData.teams.forEach {
                data.addAll(it.requests)
            }
        }

        adapter.setItems(data)
        adapter.setListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                AllData.currentRequest = data[position]

                val intent = Intent(this@RequestListActivity, RequestActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
