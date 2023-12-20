package com.mn.core.compose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.blue
import com.mn.core.extensions.noRippleClickable
import ir.kaaveh.sdpcompose.sdp

@Composable
fun SeekLoader() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
            .noRippleClickable { },
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.blue
        )
    }
}

@Composable
fun SeekPageLoader(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.sdp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.blue
        )
    }
}

@Preview
@Composable
fun SeekLoaderPreview() {
    SeekLoader()
}

@Preview
@Composable
fun SeekPageLoaderPreview() {
    SeekPageLoader(modifier = Modifier.fillMaxWidth())
}