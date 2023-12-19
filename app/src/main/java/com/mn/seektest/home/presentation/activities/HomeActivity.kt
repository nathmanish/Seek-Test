package com.mn.seektest.home.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mn.core.compose.SeekTestTheme
import com.mn.core.constants.SeekConstants.EXTRA_JOB_ID
import com.mn.core.constants.SeekConstants.EXTRA_JOB_TITLE
import com.mn.seektest.R
import com.mn.seektest.home.navigation.HomeScreenNavigator
import com.mn.seektest.home.navigation.HomeScreenRoute.*
import com.mn.seektest.home.presentation.states.ActiveJobsUIState
import com.mn.seektest.home.presentation.viewmodels.ActiveJobsViewModel
import com.mn.seektest.home.presentation.widgets.HomeScreen
import com.mn.seektest.home.presentation.widgets.JobDetailsScreen
import com.mn.seektest.home.presentation.widgets.JobScreenListener
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class HomeActivity : ComponentActivity(), JobScreenListener {

    private val activeJobsViewModel: ActiveJobsViewModel by viewModels()

    lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeekTestTheme {
                navHostController = rememberNavController()
                NavHost(
                    navController = navHostController,
                    startDestination = HomeScreen.route
                ) {
                    composable(route = HomeScreen.route) {
                        val activeJobsUIState: ActiveJobsUIState by activeJobsViewModel.activeJobs.collectAsState()

                        HomeScreen(
                            navigator = navigator,
                            activeJobsUIState = activeJobsUIState,
                            jobScreenListener = this@HomeActivity
                        )
                    }

                    composable(
                        route = JobDetailScreen.route,
                        arguments = listOf(
                            navArgument(EXTRA_JOB_ID) {
                                type = NavType.StringType
                                nullable = false
                            },
                            navArgument(EXTRA_JOB_TITLE) {
                                type = NavType.StringType
                                nullable = false
                            }
                        )
                    ) {
                        JobDetailsScreen(
                            navigator = navigator,
                            jobId = it.arguments?.getString(EXTRA_JOB_ID),
                            jobTitle = it.arguments?.getString(EXTRA_JOB_TITLE)
                        )
                    }
                }
            }
        }
    }

    private val navigator: HomeScreenNavigator by lazy {
        object : HomeScreenNavigator {
            override fun goToJobDetails(jobId: String, jobTitle: String) {
                navHostController.navigate(JobDetailScreen.passJobId(jobId, jobTitle))
            }

            override fun onBackPressed() {
                onBackPressedDispatcher.onBackPressed()
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