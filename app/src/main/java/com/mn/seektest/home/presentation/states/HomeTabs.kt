package com.mn.seektest.home.presentation.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeTabs(val label: String, val icon: ImageVector) {
    data object Jobs : HomeTabs("Jobs", Icons.Default.Home)
    data object MyJobs : HomeTabs("My Applications", Icons.Default.Favorite)
    data object Profile : HomeTabs("Profile", Icons.Default.AccountCircle)
}