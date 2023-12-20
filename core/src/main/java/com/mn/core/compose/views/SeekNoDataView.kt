package com.mn.core.compose.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.body2
import com.mn.core.compose.brandBlue
import com.mn.core.compose.textPrimary
import com.mn.core.compose.textSecondary
import com.mn.core.compose.title2
import ir.kaaveh.sdpcompose.sdp

@Composable
fun SeekNoDataView(
    imageVector: ImageVector = Icons.Default.Info,
    title: String,
    description: String
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(80.sdp),
                imageVector = imageVector,
                tint = MaterialTheme.colorScheme.brandBlue,
                contentDescription = "no-data-icon"
            )
            Text(
                modifier = Modifier.padding(top = 5.sdp),
                text = title,
                color = MaterialTheme.colorScheme.textPrimary,
                style = MaterialTheme.typography.title2
            )
            Text(
                modifier = Modifier.padding(top = 2.sdp),
                text = description,
                color = MaterialTheme.colorScheme.textSecondary,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun SeekNoDataViewPreview() {
    SeekNoDataView(
        title = "Seek",
        description = "This is a sample description"
    )
}