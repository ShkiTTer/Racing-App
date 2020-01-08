package com.example.racingapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.databinding.ActivityMainBinding
import com.example.racingapp.domain.entity.user.UserRole
import com.example.racingapp.presentation.adapter.TournamentAdapter
import com.example.racingapp.presentation.adapter.common.OnItemClickListener
import com.example.racingapp.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()
    private val adapter = TournamentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.user.value = AllData.currentUser
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            setSupportActionBar(bottomAppBar)
            user = viewModel.user
        }

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddEditTournamentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        setupList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.apply {
            when (viewModel.user.value?.role) {
                UserRole.RACER -> inflate(R.menu.menu_racer, menu)
                UserRole.ADMINISTRATOR -> inflate(R.menu.menu_admin, menu)
                UserRole.MANAGER -> inflate(R.menu.menu_manager, menu)
                UserRole.VIEWER -> inflate(R.menu.menu_viewer, menu)
            }
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.actionLogout -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.actionTeams -> {
                val intent = Intent(this, TeamListActivity::class.java)
                startActivity(intent)
            }
            R.id.actionTracks -> {
                val intent = Intent(this, TrackListActivity::class.java)
                startActivity(intent)
            }
            R.id.actionRequests -> {
                val intent = Intent(this, RequestListActivity::class.java)
                startActivity(intent)
            }
            else -> return super.onOptionsItemSelected(item)
        }

        return true
    }

    private fun setupList() {
        rvChampionShip.adapter = adapter
        adapter.setItems(AllData.tournaments)
        adapter.setListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                println("Click")
                val intent = Intent(this@MainActivity, TournamentActivity::class.java)
                AllData.currentTournament = AllData.tournaments[position]
                startActivity(intent)
            }
        })
    }
}
