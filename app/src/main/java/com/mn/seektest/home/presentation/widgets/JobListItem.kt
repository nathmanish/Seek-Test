package com.mn.seektest.home.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.body2
import com.mn.core.compose.caption3
import com.mn.core.compose.cardBackground
import com.mn.core.compose.textPrimary
import com.mn.core.compose.textSecondary
import com.mn.core.compose.title6
import com.mn.seektest.Query
import ir.kaaveh.sdpcompose.sdp

@Composable
fun JobListItem(
    index: Int,
    job: Query.Job?
) {
    Card(
        modifier = Modifier.padding(
            top = if (index == 0) 10.sdp else 0.sdp,
            bottom = 10.sdp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.cardBackground
        ),
        shape = RoundedCornerShape(2.sdp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.sdp, vertical = 20.sdp)
        ) {
            Text(
                text = job?.positionTitle ?: "",
                color = MaterialTheme.colorScheme.textPrimary,
                style = MaterialTheme.typography.title6
            )
            Text(
                modifier = Modifier.padding(top = 5.sdp),
                text = "RM ${job?.salaryRange?.min ?: "N/A"} - RM ${job?.salaryRange?.max ?: "N/A"}",
                color = MaterialTheme.colorScheme.textSecondary,
                style = MaterialTheme.typography.caption3
            )
            Text(
                modifier = Modifier.padding(top = 10.sdp),
                text = job?.description ?: "",
                color = MaterialTheme.colorScheme.textPrimary,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun JobListItemPreview() {
    JobListItem(
        index = 0,
        job = null
    )
}