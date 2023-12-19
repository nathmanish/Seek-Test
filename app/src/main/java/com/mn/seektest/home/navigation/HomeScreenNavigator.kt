package com.mn.seektest.home.navigation

interface HomeScreenNavigator {
    fun goToJobDetails(jobId: String, jobTitle: String)

    fun onBackPressed()
}