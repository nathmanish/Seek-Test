package com.mn.seektest.home.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.brandBlue
import com.mn.core.compose.cardBackground
import com.mn.core.compose.headline5
import com.mn.core.compose.textPrimary
import ir.kaaveh.sdpcompose.sdp

@Composable
fun ProfileOptionItem(
    icon: ImageVector,
    title: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.sdp)
            .clickable {
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.cardBackground
        ),
        shape = RoundedCornerShape(5.sdp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.sdp, vertical = 15.sdp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.sdp),
                imageVector = icon,
                tint = MaterialTheme.colorScheme.brandBlue,
                contentDescription = "profile-item-icon"
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.sdp),
                text = title,
                color = MaterialTheme.colorScheme.textPrimary,
                style = MaterialTheme.typography.headline5
            )
            Icon(
                modifier = Modifier.size(20.sdp),
                imageVector = Icons.Default.KeyboardArrowRight,
                tint = MaterialTheme.colorScheme.brandBlue,
                contentDescription = "profile-item-icon"
            )
        }
    }
}

@Preview
@Composable
fun ProfileOptionItemPreview() {
    ProfileOptionItem(
        icon = Icons.Default.AccountCircle,
        title = "Manage Profile"
    )
}