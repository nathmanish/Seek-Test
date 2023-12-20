package com.mn.seektest.home.presentation.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mn.core.compose.brandBlue
import com.mn.core.compose.textSecondary
import com.mn.seektest.home.navigation.HomeScreenNavigator
import com.mn.seektest.home.presentation.states.ActiveJobsUIState
import com.mn.seektest.home.presentation.states.HomeTabs
import com.mn.seektest.home.presentation.states.MyJobsUIState

@Composable
fun HomeScreen(
    navigator: HomeScreenNavigator,
    tabState: HomeTabs,
    activeJobsUIState: ActiveJobsUIState,
    myJobsUIState: MyJobsUIState,
    homeScreenListener: HomeScreenListener,
    jobScreenListener: JobScreenListener,
    myJobsListener: MyJobsListener,
    profileActionListener: ProfileActionListener
) {
    val screens = listOf(HomeTabs.Jobs, HomeTabs.MyJobs, HomeTabs.Profile)

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEach { item ->
                    NavigationBarItem(
                        selected = tabState == item,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.brandBlue,
                            indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                LocalAbsoluteTonalElevation.current
                            )
                        ),
                        label = {
                            Text(
                                text = item.label,
                                color = if (tabState == item) MaterialTheme.colorScheme.brandBlue else MaterialTheme.colorScheme.textSecondary,
                            )
                        },
                        onClick = {
                            homeScreenListener.onTabChanged(item)
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = "home_tab",
                            )
                        })
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (tabState) {
                HomeTabs.Jobs -> JobsScreen(
                    navigator = navigator,
                    jobScreenListener = jobScreenListener,
                    activeJobsUIState = activeJobsUIState
                )

                HomeTabs.MyJobs -> MyJobsScreen(
                    navigator = navigator,
                    myJobsListener = myJobsListener,
                    myJobsUIState = myJobsUIState
                )

                HomeTabs.Profile -> ProfileScreen(
                    profileActionListener = profileActionListener
                )
            }
        }
    }
}

interface HomeScreenListener {
    fun onTabChanged(tabState: HomeTabs)
}