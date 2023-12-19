package com.mn.seektest.home.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.backgroundSecondary
import com.mn.core.compose.headline6
import com.mn.core.compose.textPrimary
import com.mn.core.compose.title6
import com.mn.core.compose.views.BlueButton
import com.mn.seektest.R
import com.mn.seektest.home.navigation.HomeScreenNavigator
import ir.kaaveh.sdpcompose.sdp

@ExperimentalMaterial3Api
@Composable
fun JobDetailsScreen(
    navigator: HomeScreenNavigator?,
    jobId: String?,
    jobTitle: String?,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.backgroundSecondary
                ),
                title = {
                    Text(
                        text = jobTitle ?: "",
                        color = MaterialTheme.colorScheme.textPrimary,
                        style = MaterialTheme.typography.headline6
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigator?.onBackPressed() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "toolbar-back"
                        )
                    }
                }
            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.sdp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                JobListItem(navigator = null, index = 1, job = null)
                Text(
                    modifier = Modifier.padding(top = 20.sdp),
                    text = stringResource(id = R.string.job_responsibilities),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.title6
                )
                Text(
                    modifier = Modifier.padding(top = 10.sdp),
                    text = stringResource(id = R.string.loreal_ipsum_text),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier.padding(top = 10.sdp),
                    text = stringResource(id = R.string.loreal_ipsum_text),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier.padding(top = 10.sdp),
                    text = stringResource(id = R.string.loreal_ipsum_text),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            BlueButton(
                modifier = Modifier.padding(top = 20.sdp),
                boxModifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.apply_now),
            ) {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun JobDetailsScreenPreview() {
    JobDetailsScreen(
        navigator = null,
        jobId = "",
        jobTitle = "Job Title"
    )
}