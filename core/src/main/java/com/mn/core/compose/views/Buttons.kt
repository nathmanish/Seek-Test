package com.mn.core.compose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.mn.core.compose.blueButton
import com.mn.core.compose.brandBlue
import com.mn.core.compose.button
import com.mn.core.compose.disableButton
import com.mn.core.compose.grayButton
import com.mn.core.compose.white
import ir.kaaveh.sdpcompose.sdp


@Composable
fun BlueButton(
    modifier: Modifier = Modifier,
    boxModifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    SeekButton(
        modifier = modifier,
        boxModifier = boxModifier
            .background(
                Brush.verticalGradient(
                    colors = MaterialTheme.colorScheme.blueButton,
                ),
            )
            .padding(horizontal = 30.sdp, vertical = 16.sdp),
        text = text,
        textColor = MaterialTheme.colorScheme.white,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun ThinWhiteButton(
    modifier: Modifier = Modifier,
    boxModifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    SeekButton(
        modifier = modifier,
        boxModifier = boxModifier
            .background(
                Brush.verticalGradient(
                    colors = MaterialTheme.colorScheme.grayButton,
                ),
            )
            .padding(horizontal = 30.sdp, vertical = 10.sdp),
        text = text,
        textColor = MaterialTheme.colorScheme.brandBlue,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun DisableButton(
    modifier: Modifier = Modifier,
    boxModifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    SeekButton(
        modifier = modifier,
        boxModifier = boxModifier
            .background(
                Brush.verticalGradient(
                    colors = MaterialTheme.colorScheme.disableButton,
                ),
            )
            .padding(horizontal = 30.sdp, vertical = 16.sdp),
        text = text,
        textColor = MaterialTheme.colorScheme.white,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun SeekButton(
    modifier: Modifier = Modifier,
    boxModifier: Modifier,
    text: String,
    textColor: Color,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(10.sdp),

        elevation = elevation,
        enabled = enabled,
        onClick = { onClick() },
    ) {
        Box(
            modifier = boxModifier.clip(RoundedCornerShape(10.sdp)),
            contentAlignment = Alignment.Center,
        ) {
            Row {
                Text(
                    text = text,
                    color = textColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.button
                )
            }
        }

    }
}

@Preview
@Composable
private fun BlueButtonPreview() {
    BlueButton(
        modifier = Modifier.fillMaxWidth(),
        boxModifier = Modifier.fillMaxWidth(),
        text = "Seek",
    ) {}
}

@Preview
@Composable
private fun RedButtonPreview() {
    ThinWhiteButton(
        modifier = Modifier.fillMaxWidth(),
        boxModifier = Modifier.fillMaxWidth(),
        text = "Seek",
    ) {}
}

@Preview
@Composable
private fun DisableButtonPreview() {
    DisableButton(
        modifier = Modifier.fillMaxWidth(),
        boxModifier = Modifier.fillMaxWidth(),
        text = "Seek",
    ) {}
}