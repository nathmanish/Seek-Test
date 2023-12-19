package com.mn.seektest.home.navigation

import com.mn.core.constants.SeekConstants.EXTRA_JOB_ID
import com.mn.core.constants.SeekConstants.EXTRA_JOB_TITLE

sealed class HomeScreenRoute(val route: String) {
    data object HomeScreen : HomeScreenRoute("home_screen")

    data object JobDetailScreen :
        HomeScreenRoute("job_details_screen/{${EXTRA_JOB_ID}}/{${EXTRA_JOB_TITLE}}") {
        fun passJobId(jobId: String, jobTitle: String): String {
            return this.route.replace(
                oldValue = "{${EXTRA_JOB_ID}}",
                newValue = jobId
            ).replace(
                oldValue = "{${EXTRA_JOB_TITLE}}",
                newValue = jobTitle
            )
        }
    }
}