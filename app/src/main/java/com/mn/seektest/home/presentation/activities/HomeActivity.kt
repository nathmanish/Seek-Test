package com.mn.seektest.home.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mn.core.compose.SeekTestTheme
import com.mn.seektest.R
import com.mn.seektest.home.presentation.states.ActiveJobsUIState
import com.mn.seektest.home.presentation.viewmodels.ActiveJobsViewModel
import com.mn.seektest.home.presentation.widgets.HomeScreen
import com.mn.seektest.home.presentation.widgets.JobScreenListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity(), JobScreenListener {

    private val activeJobsViewModel: ActiveJobsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeekTestTheme {

                val activeJobsUIState: ActiveJobsUIState by activeJobsViewModel.activeJobs.collectAsState()

                HomeScreen(
                    activeJobsUIState = activeJobsUIState,
                    jobScreenListener = this
                )
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onSwipeRefresh() {
        activeJobsViewModel.getActiveJobs()
    }

    override fun onLoadError() {
        Toast.makeText(
            this@HomeActivity,
            getString(R.string.something_went_wrong),
            Toast.LENGTH_SHORT
        ).show()
    }
}