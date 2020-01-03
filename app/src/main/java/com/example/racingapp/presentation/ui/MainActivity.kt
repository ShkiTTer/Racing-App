package com.example.racingapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.racingapp.AllData
import com.example.racingapp.R
import com.example.racingapp.domain.entity.user.UserRole
import com.example.racingapp.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.user.value = AllData.currentUser
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottomAppBar)
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
            R.id.actionLogout -> finish()
            else -> return super.onOptionsItemSelected(item)
        }

        return true
    }
}
