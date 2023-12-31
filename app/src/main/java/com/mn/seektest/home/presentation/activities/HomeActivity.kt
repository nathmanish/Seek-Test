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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mn.core.compose.SeekTestTheme
import com.mn.core.constants.SeekConstants
import com.mn.core.constants.SeekConstants.EXTRA_JOB_ID
import com.mn.core.constants.SeekConstants.EXTRA_JOB_TITLE
import com.mn.core.utils.SeekPreferencesHelper
import com.mn.seektest.R
import com.mn.seektest.home.navigation.HomeScreenNavigator
import com.mn.seektest.home.navigation.HomeScreenRoute.*
import com.mn.seektest.home.presentation.states.ActiveJobsUIState
import com.mn.seektest.home.presentation.states.ApplyJobUIEvent
import com.mn.seektest.home.presentation.states.ApplyJobUIState
import com.mn.seektest.home.presentation.states.HomeTabs
import com.mn.seektest.home.presentation.states.JobDetailsUIState
import com.mn.seektest.home.presentation.states.MyJobsUIState
import com.mn.seektest.home.presentation.viewmodels.ActiveJobsViewModel
import com.mn.seektest.home.presentation.viewmodels.HomeViewModel
import com.mn.seektest.home.presentation.viewmodels.JobDetailsViewModel
import com.mn.seektest.home.presentation.viewmodels.MyJobsViewModel
import com.mn.seektest.home.presentation.widgets.HomeScreen
import com.mn.seektest.home.presentation.widgets.HomeScreenListener
import com.mn.seektest.home.presentation.widgets.JobDetailsListener
import com.mn.seektest.home.presentation.widgets.JobDetailsScreen
import com.mn.seektest.home.presentation.widgets.JobScreenListener
import com.mn.seektest.home.presentation.widgets.MyJobsListener
import com.mn.seektest.home.presentation.widgets.ProfileActionListener
import com.mn.seektest.login.presentation.activities.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class HomeActivity : ComponentActivity(),
    JobScreenListener,
    JobDetailsListener,
    MyJobsListener,
    HomeScreenListener,
    ProfileActionListener {

    private val homeViewModel: HomeViewModel by viewModels()

    private val activeJobsViewModel: ActiveJobsViewModel by viewModels()

    private val jobDetailsViewModel: JobDetailsViewModel by viewModels()

    private val myJobsViewModel: MyJobsViewModel by viewModels()

    lateinit var navHostController: NavHostController

    @Inject
    lateinit var seekPreferencesHelper: SeekPreferencesHelper

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

                        val tabState: HomeTabs by homeViewModel.homeTabState.collectAsState(initial = HomeTabs.Jobs)
                        val activeJobsUIState: ActiveJobsUIState by activeJobsViewModel.activeJobs.collectAsState()
                        val myJobsUIState: MyJobsUIState by myJobsViewModel.myJobsUIState.collectAsState()

                        HomeScreen(
                            navigator = navigator,
                            tabState = tabState,
                            activeJobsUIState = activeJobsUIState,
                            myJobsUIState = myJobsUIState,
                            homeScreenListener = this@HomeActivity,
                            jobScreenListener = this@HomeActivity,
                            myJobsListener = this@HomeActivity,
                            profileActionListener = this@HomeActivity,
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
                        val jobDetailsUIState: JobDetailsUIState by jobDetailsViewModel.jobDetailsUIState.collectAsState()
                        val applyJobUIState: ApplyJobUIState by jobDetailsViewModel.applyJobUIState.collectAsState()

                        JobDetailsScreen(
                            navigator = navigator,
                            jobDetailsUIState = jobDetailsUIState,
                            applyJobUIState = applyJobUIState,
                            jobId = it.arguments?.getString(EXTRA_JOB_ID),
                            jobTitle = it.arguments?.getString(EXTRA_JOB_TITLE),
                            jobDetailsListener = this@HomeActivity
                        )
                    }
                }
            }
        }

        observerViewModels()
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

    private fun observerViewModels() = with(lifecycleScope) {
        launch {
            jobDetailsViewModel.applyJobUIEvent.collectLatest {
                when (it) {
                    is ApplyJobUIEvent.OnError -> {
                        showErrorToast()
                    }

                    is ApplyJobUIEvent.ReloadJob -> {
                        jobDetailsViewModel.getJobDetails(it.jobId)
                        activeJobsViewModel.getActiveJobs()
                        myJobsViewModel.getMyJobs()
                    }
                }
            }
        }
    }

    private fun showErrorToast() {
        Toast.makeText(
            this@HomeActivity,
            getString(R.string.something_went_wrong),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun performSignOut() {
        seekPreferencesHelper.putBoolean(SeekConstants.IS_LOGIN, false)
        seekPreferencesHelper.putString(SeekConstants.KEY_JWT_TOKEN, "")
        LoginActivity.startActivity(this)
        finish()
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onSwipeRefresh(from: String) {
        if (from == SeekConstants.FROM_ACTIVE_JOBS) {
            activeJobsViewModel.getActiveJobs()
        } else if (from == SeekConstants.FROM_MY_JOBS) {
            myJobsViewModel.getMyJobs()
        }
    }

    override fun initJob(jobId: String) {
        jobDetailsViewModel.getJobDetails(jobId)
    }

    override fun applyJob(jobId: String) {
        jobDetailsViewModel.applyJob(jobId)
    }

    override fun onLoadError() {
        showErrorToast()
    }

    override fun onTabChanged(tabState: HomeTabs) {
        homeViewModel.updateTabState(tabState)
    }

    override fun onSignOut() {
        performSignOut()
    }
}