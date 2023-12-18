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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mn.core.compose.brandBlue
import com.mn.core.compose.textSecondary
import com.mn.seektest.home.presentation.states.HomeTabs

@Composable
fun HomeScreen() {
    var selectedTab: HomeTabs by remember {
        mutableStateOf(HomeTabs.Jobs)
    }

    val screens = listOf(HomeTabs.Jobs, HomeTabs.MyJobs, HomeTabs.Profile)

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEach { item ->
                    NavigationBarItem(
                        selected = selectedTab == item,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.brandBlue,
                            indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                LocalAbsoluteTonalElevation.current
                            )
                        ),
                        label = {
                            Text(
                                text = item.label,
                                color = if (selectedTab == item) MaterialTheme.colorScheme.brandBlue else MaterialTheme.colorScheme.textSecondary,
                            )
                        },
                        onClick = {
                            selectedTab = item
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
            when (selectedTab) {
                HomeTabs.Jobs -> JobsScreen()
                HomeTabs.MyJobs -> MyJobsScreen()
                HomeTabs.Profile -> ProfileScreen()
            }
        }
    }
}