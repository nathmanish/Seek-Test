package com.mn.seektest.home.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.backgroundSecondary
import com.mn.core.compose.caption1
import com.mn.core.compose.captionLarge
import com.mn.core.compose.headline7
import com.mn.core.compose.textPrimary
import com.mn.core.compose.textReversed
import com.mn.core.compose.textSecondary
import com.mn.core.compose.title1
import com.mn.core.compose.title4
import com.mn.core.compose.views.ThinWhiteButton
import com.mn.seektest.R
import ir.kaaveh.sdpcompose.sdp

@Composable
fun ProfileScreen(
    profileActionListener: ProfileActionListener?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.backgroundSecondary),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.sdp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(130.sdp),
                    imageVector = Icons.Default.AccountCircle,
                    tint = MaterialTheme.colorScheme.textReversed,
                    contentDescription = "profile-logo"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.sdp),
                ) {
                    Text(
                        text = stringResource(id = R.string.joined),
                        color = MaterialTheme.colorScheme.textPrimary,
                        style = MaterialTheme.typography.caption1
                    )
                    Text(
                        text = "1 Year ago",
                        color = MaterialTheme.colorScheme.textPrimary,
                        style = MaterialTheme.typography.headline7
                    )
                }
            }
            Column(
                modifier = Modifier.padding(top = 10.sdp),
            ) {
                Text(
                    text = "Manish",
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.title1
                )
                Text(
                    text = "Nath",
                    color = MaterialTheme.colorScheme.textSecondary,
                    style = MaterialTheme.typography.captionLarge
                )
                Text(
                    modifier = Modifier.padding(top = 30.sdp),
                    text = stringResource(id = R.string.profile),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.title4
                )
                ProfileOptionItem(
                    icon = Icons.Default.AccountCircle,
                    title = stringResource(id = R.string.manage_profile)
                )
                Text(
                    modifier = Modifier.padding(top = 10.sdp),
                    text = stringResource(id = R.string.settings),
                    color = MaterialTheme.colorScheme.textPrimary,
                    style = MaterialTheme.typography.title4
                )
                ProfileOptionItem(
                    icon = Icons.Default.Settings,
                    title = stringResource(id = R.string.manage_settings)
                )
                ProfileOptionItem(
                    icon = Icons.Default.Lock,
                    title = stringResource(id = R.string.change_password)
                )
            }
            ThinWhiteButton(
                modifier = Modifier
                    .padding(top = 20.sdp),
                text = stringResource(id = R.string.sign_out)
            ) {
                profileActionListener?.onSignOut()
            }
        }
    }
}

interface ProfileActionListener {
    fun onSignOut()
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        profileActionListener = null
    )
}