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
import androidx.compose.ui.unit.dp
import com.mn.core.compose.White
import com.mn.core.compose.blueBrand
import com.mn.core.compose.button


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
                    colors = MaterialTheme.colorScheme.blueBrand,
                ),
            )
            .padding(horizontal = 30.dp, vertical = 16.dp),
        text = text,
        textColor = MaterialTheme.colorScheme.White,
        enabled = enabled,
        onCLick = onClick
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
    onCLick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(50.dp),

        elevation = elevation,
        enabled = enabled,
        onClick = { onCLick() },
    ) {
        Box(
            modifier = boxModifier
                .clip(RoundedCornerShape(50.dp)),
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
fun BlueButtonPreview() {
    BlueButton(
        modifier = Modifier.fillMaxWidth(),
        boxModifier = Modifier.fillMaxWidth(),
        text = "Seek",
    ) {}
}